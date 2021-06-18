package taxi.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import taxi.dao.ManufacturerDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        return manufacturerDao.get(id).get();
    }

    @Override
    public List<Manufacturer> getAll() {
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        return manufacturerDao.delete(id);
    }

    public static class ConnectionUtil {
        public static final String URL = "jdbc:mysql://localhost:3306/taxi_db"
                + "?serverTimezone=UTC";
        public static final String USERNAME = "user";
        public static final String PASSWORD = "qwerty123456";
        public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

        static {
            try {
                Class.forName(JDBC_DRIVER);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Can't find SQL Driver", e);
            }
        }

        public static Connection getConnection() throws SQLException {
            Properties dbProperties = new Properties();
            dbProperties.setProperty("user", USERNAME);
            dbProperties.setProperty("password", PASSWORD);
            return DriverManager.getConnection(URL, dbProperties);
        }
    }
}
