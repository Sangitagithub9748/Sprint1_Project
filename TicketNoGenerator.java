
package com.ars.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class TicketNoGenerator implements IdentifierGenerator{
public int generateTicketId()
{
	Random random=new Random();
	return random.nextInt(99999);
	}
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Calendar calender=Calendar.getInstance();
		return 556+this.generateTicketId()+calender.get(Calendar.YEAR);
	}

}
