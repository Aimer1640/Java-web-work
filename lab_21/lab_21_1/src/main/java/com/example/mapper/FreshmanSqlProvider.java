package com.example.mapper;

import com.example.pojo.Freshman;
import org.apache.ibatis.jdbc.SQL;
import java.util.Map;

public class FreshmanSqlProvider {

    public String getFreshmanAll() {
        return new SQL() {
            {
                SELECT("*");
                FROM("tb_freshman");
            }
        }.toString();
    }

    public String getFreshmanById(Map<String, Object> param) {
        return new SQL() {
            {
                SELECT("*");
                FROM("tb_freshman");
                if (param.get("stuno") != null) {
                    WHERE("stuno = #{stuNo} ");
                }
            }
        }.toString();
    }

    public String getFreshmanLogin(Map<String, Object> param) {
        System.out.println(param.get("ticketNumber")+"--"+param.get("idCard"));
        String sql = "select * from tb_freshman where ticketnumber=" + param.get("ticketNumber")
                + " and id_card='" + param.get("idCard") + "'";
        return sql;
    }

    public String selectFreshmanByMultiple(Map<String, Object> param) {
        System.out.println(param.get("idCard"));
        return new SQL() {
            {
                SELECT("*");
                FROM("tb_freshman");
                if (param.get("ticketNumber") != null) {
                    WHERE("ticketnumber = #{ticketNumber} ");
                }
                if (param.get("idCard") != null) {
                    WHERE(" id_card = #{idCard} ");
                }
                if (param.get("stuNo") != null) {
                    WHERE("stuno = #{stuNo}");
                }
                if (param.get("status") != null) {
                    WHERE("status = #{status}");
                }
            }
        }.toString();
    }

    public String addFreshman(Freshman Freshman) {
        return new SQL() {
            {
                INSERT_INTO("tb_freshman");
                VALUES("sex", "#{sex}");
                VALUES("name", "#{name}");
                VALUES("age", "#{age}");
                VALUES("birthday", "#{birthday}");
                if (Freshman.getNation() != null) {
                    VALUES("nation", "#{nation}");
                }
                if (Freshman.getPolitic() != null) {
                    VALUES("politic", "#{politic}");
                }
                if (Freshman.getStatus() != null) {
                    VALUES("status", "#{status}");
                }
                if (Freshman.getRegisterTime() != null) {
                    VALUES("register_time", "#{registerTime}");
                }
                VALUES("ticketnumber", "#{ticketNumber}");
                VALUES("id_card", "#{idCard}");
                if (Freshman.getRegisterTime() != null) {
                    VALUES("register_time", "#{registerTime}");
                }
                VALUES("stuNo", "#{stuNo}");
                VALUES("dept_id", "#{deptId}");
                VALUES("major_id", "#{majorId}");
                VALUES("dorm_id", "#{dormId}");
                VALUES("class_id", "#{classId}");
                VALUES("user_id", "#{userId}");
                VALUES("role_id", "#{roleId}");
            }
        }.toString();
    }

    public String updateFreshman(Freshman Freshman) {
        return new SQL() {
            {
                UPDATE("tb_freshman");
                if (Freshman.getSex() != 0) {
                    SET("sex", "#{sex}");
                }
                if (Freshman.getName() != null) {
                    SET("name", "#{name}");
                }
                if (Freshman.getAge() != null) {
                    SET("age", "#{age}");
                }
                if (Freshman.getNation() != null) {
                    SET("nation", "#{nation}");
                }
                if (Freshman.getBirthday() != null) {
                    SET("birthday", "#{birthday}");
                }
                if (Freshman.getAge() != 0) {
                    SET("age", "#{age}");
                }
                if (Freshman.getPolitic() != null) {
                    SET("politic", "#{politic}");
                }
                if (Freshman.getStatus() != null) {
                    SET("status", "#{status}");
                }
                if (Freshman.getRegisterTime() != null) {
                    SET("register_time", "#{registerTime}");
                }
                if (Freshman.getDeptId() != null) {
                    SET("dept_id", "#{deptId}");
                }
                if (Freshman.getMajorId() != null) {
                    SET("major_id", "#{majorId}");
                }
                if (Freshman.getDormId() != null) {
                    SET("dorm_id", "#{dormId}");
                }
                if (Freshman.getClassId() != null) {
                    SET("class_id", "#{classId}");
                }
            }
        }.toString();
    }

    public String deleteFreshman(Map<String, Object> param) {
        return new SQL() {
            {
                DELETE_FROM("tb_freshman");
                if (param.get("ticketNumber") != null) {
                    WHERE(" ticketnumber = #{ticketNumber} ");
                }
                if (param.get("idCard") != null) {
                    WHERE("id_card = #{idCard}");
                }
                if (param.get("stuNo") != null) {
                    WHERE("stuno", "#{stuNo}");
                }
                if (param.get("status") != null) {
                    WHERE("status", "#{status}");
                }
            }
        }.toString();
    }

}
