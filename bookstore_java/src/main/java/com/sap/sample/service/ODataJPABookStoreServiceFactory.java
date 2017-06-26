package com.sap.sample.service;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;

public class ODataJPABookStoreServiceFactory extends ODataJPAServiceFactory {
	
	private static final int PAGE_SIZE = 5;

	@Override
	public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
		ODataJPAContext oDataJPAContext = getODataJPAContext();
		EmfHolder emfHolder = EmfHolder.createInstance();
		oDataJPAContext.setEntityManagerFactory(emfHolder.getEntityManagerFactory());
		oDataJPAContext.setPersistenceUnitName(emfHolder.getPersistenceUnitName());

		oDataJPAContext.setPageSize(PAGE_SIZE);
		setDetailErrors(true);

		return oDataJPAContext;
	}
	
	/**
	 *
	 */
	private static class EmfHolder {
		private static final String PUNIT_NAME = "bookstore";
		private static final String PUNIT_NAME_DEFAULT = "bookstore";
		private static final String DATA_SOURCE_NAME = "java:comp/env/jdbc/DefaultDB";

		final private EntityManagerFactory emf;
		final private String persistenceUnitName;

		private EmfHolder(EntityManagerFactory emf, String unitName) {
			this.emf = emf;
			this.persistenceUnitName = unitName;
		}

		public EntityManagerFactory getEntityManagerFactory() {
			return emf;
		}

		public String getPersistenceUnitName() {
			return persistenceUnitName;
		}

		public static EntityManager createEntityManager() {
			return createInstance().getEntityManagerFactory().createEntityManager();
		}


		public static synchronized EmfHolder createInstance() {
			try {
				InitialContext ctx = new InitialContext();
				Properties p = new Properties();
				EntityManagerFactory emf =
						Persistence.createEntityManagerFactory(PUNIT_NAME_DEFAULT);
				EntityManager createEntityManager = emf.createEntityManager();
				
				return new EmfHolder(emf, PUNIT_NAME_DEFAULT);
			} catch (javax.persistence.PersistenceException e) {
				return new EmfHolder(Persistence.createEntityManagerFactory(PUNIT_NAME), PUNIT_NAME);
			} catch (NamingException e) {
				return new EmfHolder(Persistence.createEntityManagerFactory(PUNIT_NAME), PUNIT_NAME);
			}
		}
	}

}
