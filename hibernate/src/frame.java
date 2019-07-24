import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.model.address;
import com.hibernate.model.batsman;
import com.hibernate.model.bowler;
import com.hibernate.model.player;




public class frame extends JFrame implements ActionListener {
 Container cp;
 JButton b1,b2,b3,b4,b5;
 JLabel lb1,lb2,lb3,lb4;
 JTextField t1,t2,t3,t4;
 JTable tb;
 
 public frame(){
	 cp=getContentPane();
	 cp.setLayout(new GridLayout(7,2));
	lb1=new JLabel("id");
	cp.add(lb1);
	t1=new JTextField(25);
	cp.add(t1);
	lb2=new JLabel("name");
	cp.add(lb2);
	t2=new JTextField(25); 
	cp.add(t2);

	lb3=new JLabel("numatches");
	cp.add(lb3);
	t3=new JTextField(25);
	cp.add(t3);

	lb4=new JLabel("readdr");
	cp.add(lb4);
	t4=new JTextField(25);
	cp.add(t4);
	
	b1=new JButton("save");
	cp.add(b1);
	b1.addActionListener(this);
	b2=new JButton("load");
	cp.add(b2);
	b2.addActionListener(this);

	b3=new JButton("update");
	cp.add(b3);
	b4=new JButton("delete");
	cp.add(b4);
	b5=new JButton("showall");
	cp.add(b5);
	b5.addActionListener(this);
	tb=new JTable(20,4);
	cp.add(new JScrollPane(tb));
	setVisible(true);
	setSize(500, 500);
	
 }
	public static void main(String[] args) {
	frame win=new frame();	

	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1){
		Session session=null;
		
			
		 Configuration config = new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory=config.buildSessionFactory(registry);
			
			session = factory.getCurrentSession();
			Transaction tr = session.beginTransaction();
			
			batsman bat1=new batsman();
			bat1.setPlayerid(101);
			bat1.setPlayername("sreeshanth");
			bat1.setNumruns(40000);
			bat1.setNummatches(220);
			address resaddr=new address("vasudharaspace","pune","maharashtra","india");
		    bat1.setResaddr(resaddr);	
		    
		    bowler bow1=new bowler();
		    bow1.setPlayerid(102);
		    bow1.setPlayername("abdeviller");
		   bow1.setNummatches(210);
		   bow1.setNumwickets(440);
			address resaddr1=new address("vasudharaspace","pune","maharashtra","india");
			bow1.setResaddr(resaddr1);	
			
			session.save(bat1);
			session.save(bow1);

	        tr.commit();
	        
	        System.out.println("record entered");
	        
	
		}
		if(e.getSource()==b2){
			int pid=Integer.parseInt(t1.getText());
			Session session=null;
			//Scanner sc = new Scanner(System.in);
			//System.out.println("enter the employeeid");
			//Sint scode=sc.nextInt();
			
			Configuration config = new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory=config.buildSessionFactory(registry);
			
			session = factory.getCurrentSession();
			Transaction tr = session.beginTransaction();
			player record = (player) session.get(player.class, pid);
			if (record != null) {
				
				//int i=Integer.parseInt(record.getPlayerid());
			  //  t1.setText(record.getPlayerid()+"");
						
				String n=record.getPlayername();//Db se retr
				t2.setText(""+n);//display in frame
			    t3.setText(record.getNummatches()+"");
			    address n1=record.getResaddr();
				t4.setText(""+n1);
				
				
				//t2.setText(""+record.getPlayername());
			} else
				System.out.println("Record Not Found!!!");

			tr.commit();
			
			
		}
		if(e.getSource()==b5){
			Configuration config=new Configuration().configure();
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory factory=config.buildSessionFactory(registry);			
			Session session=factory.getCurrentSession();
			Transaction txn=session.beginTransaction();
			
			Query q=session.createQuery("from player p");
			List<player> l=q.list();
			System.out.println(""+l);
			Iterator<player> itr=l.iterator();
			int row=0,col=0;
			while(itr.hasNext()){
				player p=itr.next();
				col=0;
				tb.setValueAt(p.getPlayerid(), row, col++);
				tb.setValueAt(p.getPlayername(), row, col++);
				tb.setValueAt(p.getNummatches(), row, col++);
		if(p instanceof bowler){
				tb.setValueAt(((bowler) p).getNumwickets(), row, col++);
		}
		/*if(p instanceof bowler){
			tb.setValueAt(p.getNumruns, row, col++);//only one can display at a time
		}
		*/
	row++;
			}
			txn.commit();
		}
}
	
	
}