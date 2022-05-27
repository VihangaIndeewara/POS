package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.SQLUtil;
import lk.ijse.pos.dao.custom.QuaryDAO;
import lk.ijse.pos.dto.CustomDTO;
import lk.ijse.pos.entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QuaryDAOImpl implements QuaryDAO {

    @Override
    public ArrayList<CustomEntity> searchOrdersByOrderId(String id) throws SQLException, ClassNotFoundException {
        String sql="select o.id,o.date,o.customerId,od.itemCode,od.qty,od.unitPrice from Orders o INNER JOIN orderDetail od ON o.id=od.orderId WHERE id=?;";
        ResultSet rst = SQLUtil.executeQuery(sql, id);

        ArrayList<CustomEntity> records =new ArrayList<>();

        while (rst.next()) {
            records.add(new CustomEntity(rst.getString(1), LocalDate.parse(rst.getString(2)),rst.getString(3),rst.getString(4),rst.getInt(5),rst.getBigDecimal(6)));
        }
        return records;
    }
}
