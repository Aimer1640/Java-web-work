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
        System.out.println(param.get("ticketNumber") + "--" + param.get("idCard"));
        String sql = "select * from tb_freshman where ticketnumber=" + param.get("ticketNumber")
                + " and id_card='" + param.get("idCard") + "'";
        return sql;
    }

    public String selectFreshmanByMultiple(Map<String, Object> param) {
        String sql=new SQL() {
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
        System.out.println(sql);
        return sql;
    }

    public String addFreshman(Freshman f) {
        String sql=new SQL() {
            {
                INSERT_INTO("tb_freshman");
                if (f.getSex() != null) {
                  VALUES("sex", "#{sex}");
                }
                if (f.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (f.getAge() != null) {
                    VALUES("age", "#{age}");
                }
                if (f.getBirthday() != null) {
                    VALUES("birthday", "#{birthday}");
                }
                if (f.getNation() != null) {
                    VALUES("nation", "#{nation}");
                }
                if (f.getPolitic() != null) {
                    VALUES("politic", "#{politic}");
                }
                if (f.getStatus() != null) {
                    VALUES("status", "#{status}");
                }
                if (f.getRegisterTime() != null) {
                    VALUES("register_time", "#{registerTime}");
                }
                if (f.getTicketNumber() != null) {
                    VALUES("ticketnumber", "#{ticketNumber}");
                }
                if (f.getIdCard() != null) {
                    VALUES("id_card", "#{idCard}");
                }
                if (f.getStuNo() != null) {
                    VALUES("stuNo", "#{stuNo}");
                }
                if (f.getDeptId() != null) {
                    VALUES("dept_id", "#{deptId}");
                }
                if (f.getMajorId() != null) {
                    VALUES("major_id", "#{majorId}");
                }
                if (f.getDormId() != null) {
                    VALUES("dorm_id", "#{dormId}");
                }
                if (f.getClassId() != null) {
                    VALUES("class_id", "#{classId}");
                }
                if (f.getUserId() != null) {
                    VALUES("user_id", "#{userId}");
                }
                if (f.getRoleId() != null) {
                    VALUES("role_id", "#{roleId}");
                }
            }
        }.toString();
        System.out.println("addFreshman"+sql);
        return sql;
    }

    public String updateFreshman(Freshman f) {
        String sql=new SQL() {
            {
                UPDATE("tb_freshman");
                if (f.getSex() != 0) {
                    SET("sex=#{sex}");
                }
                if (f.getName() != null) {
                    SET("name=#{name}");
                }
                if (f.getAge() != null) {
                    SET("age=#{age}");
                }
                if (f.getNation() != null) {
                    SET("nation=#{nation}");
                }
                if (f.getBirthday() != null) {
                    SET("birthday", "#{birthday}");
                }
                if (f.getAge() != 0) {
                    SET("age=#{age}");
                }
                if (f.getPolitic() != null) {
                    SET("politic=#{politic}");
                }
                if (f.getStatus() != null) {
                    SET("status=#{status}");
                }
                if (f.getRegisterTime() != null) {
                    SET("register_time=#{registerTime}");
                }
                if (f.getDeptId() != null) {
                    SET("dept_id=#{deptId}");
                }
                if (f.getMajorId() != null) {
                    SET("major_id=#{majorId}");
                }
                if (f.getDormId() != null) {
                    SET("dorm_id=#{dormId}");
                }
                if (f.getClassId() != null) {
                    SET("class_id=#{classId}");
                }
                WHERE("id_card= #{idCard}");
            }
        }.toString();
        System.out.println("UpdateFreshman:"+sql);
        return sql;
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
