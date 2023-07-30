package org.quasar.ic.common.infrastructure.po.extension;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.util.Collections;
import java.util.List;

/**
 * @author Quasar
 * @version 1.0.0
 * @since 2023/7/26 21:54
 */
@MappedJdbcTypes(JdbcType.ARRAY)
@MappedTypes(List.class)
public class ListOfIntegerTypeHandler extends BaseTypeHandler<List<Integer>> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List<Integer> integers, JdbcType jdbcType) throws SQLException {
        Connection connection = preparedStatement.getConnection();
        Integer[] integers1 = integers.toArray(new Integer[0]);
        Array array = connection.createArrayOf("integer", integers1);
        preparedStatement.setArray(i, array);
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Array array = resultSet.getArray(s);
        if (array != null) {
            return List.of((Integer[]) array.getArray());
        }
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Array array = resultSet.getArray(i);
        if (array != null) {
            return List.of((Integer[]) array.getArray());
        }
        return Collections.emptyList();
    }

    @Override
    public List<Integer> getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Array array = callableStatement.getArray(i);
        if (array != null) {
            return List.of((Integer[]) array.getArray());
        }
        return Collections.emptyList();
    }
}
