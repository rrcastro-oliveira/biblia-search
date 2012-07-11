package santes.toni.bibliasearch;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;


class HibernateConfig
{
	private static Configuration configuration = null;
	private static SessionFactory factory = null;
	
	public static SessionFactory getSessionFactory() {
		if (factory == null)
			factory = getConfiguration().buildSessionFactory();
		return factory;
	}
	
	public static void iniciarHibernate() {
		getSessionFactory();
	}
	
	public static Configuration getConfiguration() {
		if (configuration == null) {
			configuration = new Configuration();
			addProperties(configuration);
			addMapping(configuration);
		}
		return configuration;
	}
	

	private static void addMapping(Configuration ac) {
		ac.addAnnotatedClass(Versiculo.class);
	}

	private static void addProperties(Configuration ac) {
		ac.addProperties(poolConnectionsProperties());
		ac.addProperties(sqlProperties());
		ac.addProperties(databaseConnectionProperties());
	}
	

	private static Properties sqlProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.use_sql_comments", "true");
		properties.setProperty("hibernate.query.substitutions", "yes 'Y', no 'N'");
		properties.setProperty("javax.persistence.validation.mode", "none");
		return properties;
	}

	private static Properties poolConnectionsProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.c3p0.max_size", "100");
		properties.setProperty("hibernate.c3p0.min_size", "5");
		properties.setProperty("hibernate.c3p0.timeout", "60");
		properties.setProperty("hibernate.c3p0.max_statements", "50");
		//props.setProperty("hibernate.c3p0.idle_test_period", "120");
		properties.setProperty("hibernate.c3p0.acquire_increment", "5");
		properties.setProperty("hibernate.c3p0.validate", "false");
		properties.setProperty("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
		return properties;
	}
	
	private static Properties databaseConnectionProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.FirebirdDialect");
		properties.setProperty("hibernate.connection.driver_class", "org.firebirdsql.jdbc.FBDriver");
		properties.setProperty("hibernate.connection.url", "jdbc:firebirdsql:localhost/3050:biblia");
		properties.setProperty("hibernate.connection.username", "SYSDBA");
		properties.setProperty("hibernate.connection.password", "masterkey");
		properties.setProperty("hibernate.current_session_context_class", "thread");
		return properties;
	}
	
	public static void gerarBanco(boolean somenteAtualizar) {
		Configuration configuration = HibernateConfig.getConfiguration();
		
		//s� mudar aki pra gerar ou atualizar o banco
		if(somenteAtualizar)
		{
			SchemaUpdate su = new SchemaUpdate(configuration);
			su.execute(true, true);
		}
		else
		{
			SchemaExport se = new SchemaExport(configuration);
			se.create(true, true);
		}	
	}
}
