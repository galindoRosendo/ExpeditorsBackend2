package com.expeditors.adoptionapp.dao.jpa;

import com.expeditors.adoptionapp.dao.AdopterDAO;
import com.expeditors.adoptionapp.domain.Adopter;
import com.expeditors.adoptionapp.domain.Pet;
import com.expeditors.adoptionapp.enums.TypesOfPets;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JPAAdotperDAO implements AdopterDAO {
    JdbcTemplate jdbcClient;
    public JPAAdotperDAO(){
        String url = "jdbc:postgresql://localhost:5433/adoptapp";
        String user = "larku";
        String pw = "larku";
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, pw);
        jdbcClient = new JdbcTemplate(dataSource);
    }
    @Override
    public Adopter insert(Adopter adopter) {
        String sql = "insert into adopter (name, phone) values (?, ?)";

        Object [] arr = new Object[]{adopter.getName(), adopter.getPhone()};

        List<Object[]> params = new ArrayList<>();
        params.add(arr);

        long id = insertMultiple(adopter);

        if (adopter.getPets() != null) {
            String sqlPet = "insert into pet (date_of_adoption, type_of_pet, name, breed, id_adopter) values (?, ?, ?, ?, ?);";
            Object [] arrPet = new Object[]{LocalDate.now(), 1, adopter.getPets().getFirst().getName(), adopter.getPets().getFirst().getBreed(), id};
            params.add(arrPet);
            jdbcClient.update(sqlPet, arrPet);
        }

        return adopter;
    }

    public Integer insertMultiple(Adopter adopter) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "insert into adopter (name, phone) values (?, ?)";

        jdbcClient.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, adopter.getName());
            ps.setString(2, adopter.getPhone());
            return ps;
        }, keyHolder);

        return (Integer)keyHolder.getKeyList().getFirst().get("id_adopter");
    }

    @Override
    public boolean delete(int id) {

        String sql = "delete from adopter where adopter_id = ?";

        Object [] arr = new Object[]{1};

        List<Object[]> params = new ArrayList<>();
        params.add(arr);

        int numRows = 0;

        for(Object[] args : params) {
            numRows += jdbcClient.update(sql, args);
        }

        return numRows > 0;
    }

    @Override
    public boolean update(Adopter adopter) {
        String sql = "update adopter set name = ?, phone = ? where adopter_id = ?";

        Object [] arr = new Object[]{"Rosendo", "8671413415", 1};

        List<Object[]> params = new ArrayList<>();
        params.add(arr);

        int numRows = 0;

        for(Object[] args : params) {
            numRows += jdbcClient.update(sql, args);
        }

        return numRows > 0;

    }

    @Override
    public Adopter findBy(int id) {
        String sql = "select a.id_adopter, a.name, phone, p.name as petName from Adopter a join Pet p on a.id_adopter = p.id_adopter where a.id_adopter = ?";

        RowMapper<Adopter> rowMapper = (resultSet, rowNum) -> {
            int id_adopter = resultSet.getInt("id_adopter");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String petName = resultSet.getString("petName");

            Pet newPet = new Pet();
            newPet.setName(petName);

            var newObj = new Adopter();
            newObj.setId(id_adopter);
            newObj.setName(name);
            newObj.setPhone(phone);
            //newObj.setPets(newPet);
            return newObj;
        };

        return jdbcClient.query(sql, rowMapper, id).getFirst();
    }

    @Override
    public Adopter findBy(String nameParam) {
        String sql = "select id_adopter, name, phone from Adopter where name = ?";

        RowMapper<Adopter> rowMapper = (resultSet, rowNum) -> {
            int id_adopter = resultSet.getInt("id_adopter");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");

            var newObj = new Adopter();
            newObj.setId(id_adopter);
            newObj.setName(name);
            newObj.setPhone(phone);
            return newObj;
        };

        return jdbcClient.query(sql, rowMapper, nameParam).getFirst();
    }

    @Override
    public List<Adopter> findAll() {

        String sql = "select id_adopter, name, phone from Adopter";

        RowMapper<Adopter> rowMapper = (resultSet, rowNum) -> {
            int id_adopter = resultSet.getInt("id_adopter");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");

            var newObj = new Adopter();
            newObj.setId(id_adopter);
            newObj.setName(name);
            newObj.setPhone(phone);
            return newObj;
        };

        return jdbcClient.query(sql, rowMapper, null);
    }
    @Override
    public List<Adopter> sortByNaturalOrder() {
        String sql = "select id_adopter, name, phone from Adopter order by id_adopter";

        RowMapper<Adopter> rowMapper = (resultSet, rowNum) -> {
            int id_adopter = resultSet.getInt("id_adopter");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");

            var newObj = new Adopter();
            newObj.setId(id_adopter);
            newObj.setName(name);
            newObj.setPhone(phone);
            return newObj;
        };

        return jdbcClient.query(sql, rowMapper, null);
    }

    @Override
    public List<Adopter> sortByName() {
        String sql = "select id_adopter, name, phone from Adopter order by name";

        RowMapper<Adopter> rowMapper = (resultSet, rowNum) -> {
            int id_adopter = resultSet.getInt("id_adopter");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");

            var newObj = new Adopter();
            newObj.setId(id_adopter);
            newObj.setName(name);
            newObj.setPhone(phone);
            return newObj;
        };

        return jdbcClient.query(sql, rowMapper, null);
    }
}
