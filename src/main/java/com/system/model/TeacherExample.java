package com.system.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class TeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TeacherExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNull() {
            addCriterion("teacher_sex is null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIsNotNull() {
            addCriterion("teacher_sex is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherSexEqualTo(String value) {
            addCriterion("teacher_sex =", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotEqualTo(String value) {
            addCriterion("teacher_sex <>", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThan(String value) {
            addCriterion("teacher_sex >", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_sex >=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThan(String value) {
            addCriterion("teacher_sex <", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLessThanOrEqualTo(String value) {
            addCriterion("teacher_sex <=", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexLike(String value) {
            addCriterion("teacher_sex like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotLike(String value) {
            addCriterion("teacher_sex not like", value, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexIn(List<String> values) {
            addCriterion("teacher_sex in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotIn(List<String> values) {
            addCriterion("teacher_sex not in", values, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexBetween(String value1, String value2) {
            addCriterion("teacher_sex between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherSexNotBetween(String value1, String value2) {
            addCriterion("teacher_sex not between", value1, value2, "teacherSex");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayIsNull() {
            addCriterion("teacher_birthday is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayIsNotNull() {
            addCriterion("teacher_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday =", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday <>", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("teacher_birthday >", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday >=", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("teacher_birthday <", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_birthday <=", value, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_birthday in", values, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_birthday not in", values, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_birthday between", value1, value2, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_birthday not between", value1, value2, "teacherBirthday");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeIsNull() {
            addCriterion("teacher_degree is null");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeIsNotNull() {
            addCriterion("teacher_degree is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeEqualTo(String value) {
            addCriterion("teacher_degree =", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotEqualTo(String value) {
            addCriterion("teacher_degree <>", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeGreaterThan(String value) {
            addCriterion("teacher_degree >", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_degree >=", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeLessThan(String value) {
            addCriterion("teacher_degree <", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeLessThanOrEqualTo(String value) {
            addCriterion("teacher_degree <=", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeLike(String value) {
            addCriterion("teacher_degree like", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotLike(String value) {
            addCriterion("teacher_degree not like", value, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeIn(List<String> values) {
            addCriterion("teacher_degree in", values, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotIn(List<String> values) {
            addCriterion("teacher_degree not in", values, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeBetween(String value1, String value2) {
            addCriterion("teacher_degree between", value1, value2, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherDegreeNotBetween(String value1, String value2) {
            addCriterion("teacher_degree not between", value1, value2, "teacherDegree");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIsNull() {
            addCriterion("teacher_position is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIsNotNull() {
            addCriterion("teacher_position is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionEqualTo(String value) {
            addCriterion("teacher_position =", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotEqualTo(String value) {
            addCriterion("teacher_position <>", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionGreaterThan(String value) {
            addCriterion("teacher_position >", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_position >=", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLessThan(String value) {
            addCriterion("teacher_position <", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLessThanOrEqualTo(String value) {
            addCriterion("teacher_position <=", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionLike(String value) {
            addCriterion("teacher_position like", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotLike(String value) {
            addCriterion("teacher_position not like", value, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionIn(List<String> values) {
            addCriterion("teacher_position in", values, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotIn(List<String> values) {
            addCriterion("teacher_position not in", values, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionBetween(String value1, String value2) {
            addCriterion("teacher_position between", value1, value2, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherPositionNotBetween(String value1, String value2) {
            addCriterion("teacher_position not between", value1, value2, "teacherPosition");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateIsNull() {
            addCriterion("teacher_hiredate is null");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateIsNotNull() {
            addCriterion("teacher_hiredate is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_hiredate =", value, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateNotEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_hiredate <>", value, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateGreaterThan(Date value) {
            addCriterionForJDBCDate("teacher_hiredate >", value, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_hiredate >=", value, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateLessThan(Date value) {
            addCriterionForJDBCDate("teacher_hiredate <", value, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("teacher_hiredate <=", value, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_hiredate in", values, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateNotIn(List<Date> values) {
            addCriterionForJDBCDate("teacher_hiredate not in", values, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_hiredate between", value1, value2, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andTeacherHiredateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("teacher_hiredate not between", value1, value2, "teacherHiredate");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNull() {
            addCriterion("college_id is null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIsNotNull() {
            addCriterion("college_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollegeIdEqualTo(Integer value) {
            addCriterion("college_id =", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotEqualTo(Integer value) {
            addCriterion("college_id <>", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThan(Integer value) {
            addCriterion("college_id >", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("college_id >=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThan(Integer value) {
            addCriterion("college_id <", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdLessThanOrEqualTo(Integer value) {
            addCriterion("college_id <=", value, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdIn(List<Integer> values) {
            addCriterion("college_id in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotIn(List<Integer> values) {
            addCriterion("college_id not in", values, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdBetween(Integer value1, Integer value2) {
            addCriterion("college_id between", value1, value2, "collegeId");
            return (Criteria) this;
        }

        public Criteria andCollegeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("college_id not between", value1, value2, "collegeId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}