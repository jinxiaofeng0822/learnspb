package com.jxf.learnspb.entity;

import java.util.ArrayList;
import java.util.List;

public class NewtbExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewtbExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQwErIsNull() {
            addCriterion("qw_er is null");
            return (Criteria) this;
        }

        public Criteria andQwErIsNotNull() {
            addCriterion("qw_er is not null");
            return (Criteria) this;
        }

        public Criteria andQwErEqualTo(String value) {
            addCriterion("qw_er =", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErNotEqualTo(String value) {
            addCriterion("qw_er <>", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErGreaterThan(String value) {
            addCriterion("qw_er >", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErGreaterThanOrEqualTo(String value) {
            addCriterion("qw_er >=", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErLessThan(String value) {
            addCriterion("qw_er <", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErLessThanOrEqualTo(String value) {
            addCriterion("qw_er <=", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErLike(String value) {
            addCriterion("qw_er like", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErNotLike(String value) {
            addCriterion("qw_er not like", value, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErIn(List<String> values) {
            addCriterion("qw_er in", values, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErNotIn(List<String> values) {
            addCriterion("qw_er not in", values, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErBetween(String value1, String value2) {
            addCriterion("qw_er between", value1, value2, "qwEr");
            return (Criteria) this;
        }

        public Criteria andQwErNotBetween(String value1, String value2) {
            addCriterion("qw_er not between", value1, value2, "qwEr");
            return (Criteria) this;
        }

        public Criteria andAsDfIsNull() {
            addCriterion("as_df is null");
            return (Criteria) this;
        }

        public Criteria andAsDfIsNotNull() {
            addCriterion("as_df is not null");
            return (Criteria) this;
        }

        public Criteria andAsDfEqualTo(String value) {
            addCriterion("as_df =", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfNotEqualTo(String value) {
            addCriterion("as_df <>", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfGreaterThan(String value) {
            addCriterion("as_df >", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfGreaterThanOrEqualTo(String value) {
            addCriterion("as_df >=", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfLessThan(String value) {
            addCriterion("as_df <", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfLessThanOrEqualTo(String value) {
            addCriterion("as_df <=", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfLike(String value) {
            addCriterion("as_df like", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfNotLike(String value) {
            addCriterion("as_df not like", value, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfIn(List<String> values) {
            addCriterion("as_df in", values, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfNotIn(List<String> values) {
            addCriterion("as_df not in", values, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfBetween(String value1, String value2) {
            addCriterion("as_df between", value1, value2, "asDf");
            return (Criteria) this;
        }

        public Criteria andAsDfNotBetween(String value1, String value2) {
            addCriterion("as_df not between", value1, value2, "asDf");
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