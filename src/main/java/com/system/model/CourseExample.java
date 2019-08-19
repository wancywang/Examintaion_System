package com.system.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: Alex
 * @Date: 2019/6/28 2:09
 */
public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
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

        public Criteria andCourseTimeIsNull() {
            addCriterion("course_time is null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIsNotNull() {
            addCriterion("course_time is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTimeEqualTo(String value) {
            addCriterion("course_time =", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotEqualTo(String value) {
            addCriterion("course_time <>", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeGreaterThan(String value) {
            addCriterion("course_time >", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("course_time >=", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLessThan(String value) {
            addCriterion("course_time <", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLessThanOrEqualTo(String value) {
            addCriterion("course_time <=", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeLike(String value) {
            addCriterion("course_time like", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotLike(String value) {
            addCriterion("course_time not like", value, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeIn(List<String> values) {
            addCriterion("course_time in", values, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotIn(List<String> values) {
            addCriterion("course_time not in", values, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeBetween(String value1, String value2) {
            addCriterion("course_time between", value1, value2, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseTimeNotBetween(String value1, String value2) {
            addCriterion("course_time not between", value1, value2, "courseTime");
            return (Criteria) this;
        }

        public Criteria andCourseYearIsNull() {
            addCriterion("course_year is null");
            return (Criteria) this;
        }

        public Criteria andCourseYearIsNotNull() {
            addCriterion("course_year is not null");
            return (Criteria) this;
        }

        public Criteria andCourseYearEqualTo(Date value) {
            addCriterionForJDBCDate("course_year =", value, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearNotEqualTo(Date value) {
            addCriterionForJDBCDate("course_year <>", value, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearGreaterThan(Date value) {
            addCriterionForJDBCDate("course_year >", value, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("course_year >=", value, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearLessThan(Date value) {
            addCriterionForJDBCDate("course_year <", value, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("course_year <=", value, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearIn(List<Date> values) {
            addCriterionForJDBCDate("course_year in", values, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearNotIn(List<Date> values) {
            addCriterionForJDBCDate("course_year not in", values, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("course_year between", value1, value2, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseYearNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("course_year not between", value1, value2, "courseYear");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomIsNull() {
            addCriterion("course_classoom is null");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomIsNotNull() {
            addCriterion("course_classoom is not null");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomEqualTo(String value) {
            addCriterion("course_classoom =", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomNotEqualTo(String value) {
            addCriterion("course_classoom <>", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomGreaterThan(String value) {
            addCriterion("course_classoom >", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomGreaterThanOrEqualTo(String value) {
            addCriterion("course_classoom >=", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomLessThan(String value) {
            addCriterion("course_classoom <", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomLessThanOrEqualTo(String value) {
            addCriterion("course_classoom <=", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomLike(String value) {
            addCriterion("course_classoom like", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomNotLike(String value) {
            addCriterion("course_classoom not like", value, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomIn(List<String> values) {
            addCriterion("course_classoom in", values, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomNotIn(List<String> values) {
            addCriterion("course_classoom not in", values, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomBetween(String value1, String value2) {
            addCriterion("course_classoom between", value1, value2, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCourseClassoomNotBetween(String value1, String value2) {
            addCriterion("course_classoom not between", value1, value2, "courseClassoom");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodIsNull() {
            addCriterion("\"course_ period\" is null");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodIsNotNull() {
            addCriterion("\"course_ period\" is not null");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodEqualTo(Integer value) {
            addCriterion("\"course_ period\" =", value, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodNotEqualTo(Integer value) {
            addCriterion("\"course_ period\" <>", value, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodGreaterThan(Integer value) {
            addCriterion("\"course_ period\" >", value, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"course_ period\" >=", value, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodLessThan(Integer value) {
            addCriterion("\"course_ period\" <", value, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodLessThanOrEqualTo(Integer value) {
            addCriterion("\"course_ period\" <=", value, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodIn(List<Integer> values) {
            addCriterion("\"course_ period\" in", values, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodNotIn(List<Integer> values) {
            addCriterion("\"course_ period\" not in", values, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodBetween(Integer value1, Integer value2) {
            addCriterion("\"course_ period\" between", value1, value2, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCoursePeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("\"course_ period\" not between", value1, value2, "coursePeriod");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
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

        public Criteria andCourseScoreIsNull() {
            addCriterion("course_score is null");
            return (Criteria) this;
        }

        public Criteria andCourseScoreIsNotNull() {
            addCriterion("course_score is not null");
            return (Criteria) this;
        }

        public Criteria andCourseScoreEqualTo(Integer value) {
            addCriterion("course_score =", value, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreNotEqualTo(Integer value) {
            addCriterion("course_score <>", value, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreGreaterThan(Integer value) {
            addCriterion("course_score >", value, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_score >=", value, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreLessThan(Integer value) {
            addCriterion("course_score <", value, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreLessThanOrEqualTo(Integer value) {
            addCriterion("course_score <=", value, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreIn(List<Integer> values) {
            addCriterion("course_score in", values, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreNotIn(List<Integer> values) {
            addCriterion("course_score not in", values, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreBetween(Integer value1, Integer value2) {
            addCriterion("course_score between", value1, value2, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("course_score not between", value1, value2, "courseScore");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlIsNull() {
            addCriterion("course_videourl is null");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlIsNotNull() {
            addCriterion("course_videourl is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlEqualTo(String value) {
            addCriterion("course_videourl =", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlNotEqualTo(String value) {
            addCriterion("course_videourl <>", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlGreaterThan(String value) {
            addCriterion("course_videourl >", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlGreaterThanOrEqualTo(String value) {
            addCriterion("course_videourl >=", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlLessThan(String value) {
            addCriterion("course_videourl <", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlLessThanOrEqualTo(String value) {
            addCriterion("course_videourl <=", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlLike(String value) {
            addCriterion("course_videourl like", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlNotLike(String value) {
            addCriterion("course_videourl not like", value, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlIn(List<String> values) {
            addCriterion("course_videourl in", values, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlNotIn(List<String> values) {
            addCriterion("course_videourl not in", values, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlBetween(String value1, String value2) {
            addCriterion("course_videourl between", value1, value2, "courseVideourl");
            return (Criteria) this;
        }

        public Criteria andCourseVideourlNotBetween(String value1, String value2) {
            addCriterion("course_videourl not between", value1, value2, "courseVideourl");
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