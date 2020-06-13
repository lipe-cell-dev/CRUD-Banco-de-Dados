/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.unicarioca.modelo.Aluno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.concurrent.TimeUnit;
/**
 *
 * @author podgorski
 */
public class CrudHibernate {
    public static void main(String[] args) throws InterruptedException {
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");
		cfg.addAnnotatedClass(Aluno.class);
		SessionFactory sf = cfg.buildSessionFactory();
            try (Session session = sf.openSession()) {
                Transaction tx = session.beginTransaction();
                Aluno aluno = new Aluno();
                aluno.setNome("Antonio Podgorski");
                aluno.setMatr(2003001293);
                aluno.setTelefone("2222-2222");
                session.save(aluno);
                tx.commit();
            }
            
                TimeUnit.SECONDS.sleep(30);
                
                sf.close();
                
		System.out.println("Fim");
	}
}
