package com.pj.system.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserQuery {
	private String username;
	
	private Integer companyid;
   
	private Integer dempid;
	
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer pageNo = 1;

    protected Integer startRow;

    protected Integer pageSize = 10;

    protected String fields;

    public UserQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }
    

    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Integer getCompanyid() {
		return companyid;
	}


	public void setCompanyid(Integer companyid) {
		this.companyid = companyid;
	}


	public Integer getDempid() {
		return dempid;
	}


	public void setDempid(Integer dempid) {
		this.dempid = dempid;
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

    public void setPageNo(Integer pageNo) {
        this.pageNo=pageNo;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setStartRow(Integer startRow) {
        this.startRow=startRow;
    }

    public Integer getStartRow() {
        return startRow;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize=pageSize;
        this.startRow = (pageNo-1)*this.pageSize;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andFilenumberIsNull() {
            addCriterion("filenumber is null");
            return (Criteria) this;
        }

        public Criteria andFilenumberIsNotNull() {
            addCriterion("filenumber is not null");
            return (Criteria) this;
        }

        public Criteria andFilenumberEqualTo(String value) {
            addCriterion("filenumber =", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberNotEqualTo(String value) {
            addCriterion("filenumber <>", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberGreaterThan(String value) {
            addCriterion("filenumber >", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberGreaterThanOrEqualTo(String value) {
            addCriterion("filenumber >=", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberLessThan(String value) {
            addCriterion("filenumber <", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberLessThanOrEqualTo(String value) {
            addCriterion("filenumber <=", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberLike(String value) {
            addCriterion("filenumber like", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberNotLike(String value) {
            addCriterion("filenumber not like", value, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberIn(List<String> values) {
            addCriterion("filenumber in", values, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberNotIn(List<String> values) {
            addCriterion("filenumber not in", values, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberBetween(String value1, String value2) {
            addCriterion("filenumber between", value1, value2, "filenumber");
            return (Criteria) this;
        }

        public Criteria andFilenumberNotBetween(String value1, String value2) {
            addCriterion("filenumber not between", value1, value2, "filenumber");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNull() {
            addCriterion("hiredate is null");
            return (Criteria) this;
        }

        public Criteria andHiredateIsNotNull() {
            addCriterion("hiredate is not null");
            return (Criteria) this;
        }

        public Criteria andHiredateEqualTo(Date value) {
            addCriterion("hiredate =", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotEqualTo(Date value) {
            addCriterion("hiredate <>", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThan(Date value) {
            addCriterion("hiredate >", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateGreaterThanOrEqualTo(Date value) {
            addCriterion("hiredate >=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThan(Date value) {
            addCriterion("hiredate <", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateLessThanOrEqualTo(Date value) {
            addCriterion("hiredate <=", value, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateIn(List<Date> values) {
            addCriterion("hiredate in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotIn(List<Date> values) {
            addCriterion("hiredate not in", values, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateBetween(Date value1, Date value2) {
            addCriterion("hiredate between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andHiredateNotBetween(Date value1, Date value2) {
            addCriterion("hiredate not between", value1, value2, "hiredate");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andIdentityproofIsNull() {
            addCriterion("identityproof is null");
            return (Criteria) this;
        }

        public Criteria andIdentityproofIsNotNull() {
            addCriterion("identityproof is not null");
            return (Criteria) this;
        }

        public Criteria andIdentityproofEqualTo(String value) {
            addCriterion("identityproof =", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofNotEqualTo(String value) {
            addCriterion("identityproof <>", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofGreaterThan(String value) {
            addCriterion("identityproof >", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofGreaterThanOrEqualTo(String value) {
            addCriterion("identityproof >=", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofLessThan(String value) {
            addCriterion("identityproof <", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofLessThanOrEqualTo(String value) {
            addCriterion("identityproof <=", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofLike(String value) {
            addCriterion("identityproof like", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofNotLike(String value) {
            addCriterion("identityproof not like", value, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofIn(List<String> values) {
            addCriterion("identityproof in", values, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofNotIn(List<String> values) {
            addCriterion("identityproof not in", values, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofBetween(String value1, String value2) {
            addCriterion("identityproof between", value1, value2, "identityproof");
            return (Criteria) this;
        }

        public Criteria andIdentityproofNotBetween(String value1, String value2) {
            addCriterion("identityproof not between", value1, value2, "identityproof");
            return (Criteria) this;
        }

        public Criteria andRegularpayIsNull() {
            addCriterion("regularpay is null");
            return (Criteria) this;
        }

        public Criteria andRegularpayIsNotNull() {
            addCriterion("regularpay is not null");
            return (Criteria) this;
        }

        public Criteria andRegularpayEqualTo(String value) {
            addCriterion("regularpay =", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayNotEqualTo(String value) {
            addCriterion("regularpay <>", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayGreaterThan(String value) {
            addCriterion("regularpay >", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayGreaterThanOrEqualTo(String value) {
            addCriterion("regularpay >=", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayLessThan(String value) {
            addCriterion("regularpay <", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayLessThanOrEqualTo(String value) {
            addCriterion("regularpay <=", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayLike(String value) {
            addCriterion("regularpay like", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayNotLike(String value) {
            addCriterion("regularpay not like", value, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayIn(List<String> values) {
            addCriterion("regularpay in", values, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayNotIn(List<String> values) {
            addCriterion("regularpay not in", values, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayBetween(String value1, String value2) {
            addCriterion("regularpay between", value1, value2, "regularpay");
            return (Criteria) this;
        }

        public Criteria andRegularpayNotBetween(String value1, String value2) {
            addCriterion("regularpay not between", value1, value2, "regularpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayIsNull() {
            addCriterion("probationpay is null");
            return (Criteria) this;
        }

        public Criteria andProbationpayIsNotNull() {
            addCriterion("probationpay is not null");
            return (Criteria) this;
        }

        public Criteria andProbationpayEqualTo(String value) {
            addCriterion("probationpay =", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayNotEqualTo(String value) {
            addCriterion("probationpay <>", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayGreaterThan(String value) {
            addCriterion("probationpay >", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayGreaterThanOrEqualTo(String value) {
            addCriterion("probationpay >=", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayLessThan(String value) {
            addCriterion("probationpay <", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayLessThanOrEqualTo(String value) {
            addCriterion("probationpay <=", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayLike(String value) {
            addCriterion("probationpay like", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayNotLike(String value) {
            addCriterion("probationpay not like", value, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayIn(List<String> values) {
            addCriterion("probationpay in", values, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayNotIn(List<String> values) {
            addCriterion("probationpay not in", values, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayBetween(String value1, String value2) {
            addCriterion("probationpay between", value1, value2, "probationpay");
            return (Criteria) this;
        }

        public Criteria andProbationpayNotBetween(String value1, String value2) {
            addCriterion("probationpay not between", value1, value2, "probationpay");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andDempidIsNull() {
            addCriterion("dempid is null");
            return (Criteria) this;
        }

        public Criteria andDempidIsNotNull() {
            addCriterion("dempid is not null");
            return (Criteria) this;
        }

        public Criteria andDempidEqualTo(Integer value) {
            addCriterion("dempid =", value, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidNotEqualTo(Integer value) {
            addCriterion("dempid <>", value, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidGreaterThan(Integer value) {
            addCriterion("dempid >", value, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dempid >=", value, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidLessThan(Integer value) {
            addCriterion("dempid <", value, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidLessThanOrEqualTo(Integer value) {
            addCriterion("dempid <=", value, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidIn(List<Integer> values) {
            addCriterion("dempid in", values, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidNotIn(List<Integer> values) {
            addCriterion("dempid not in", values, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidBetween(Integer value1, Integer value2) {
            addCriterion("dempid between", value1, value2, "dempid");
            return (Criteria) this;
        }

        public Criteria andDempidNotBetween(Integer value1, Integer value2) {
            addCriterion("dempid not between", value1, value2, "dempid");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNull() {
            addCriterion("birthdate is null");
            return (Criteria) this;
        }

        public Criteria andBirthdateIsNotNull() {
            addCriterion("birthdate is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdateEqualTo(Date value) {
            addCriterion("birthdate =", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotEqualTo(Date value) {
            addCriterion("birthdate <>", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThan(Date value) {
            addCriterion("birthdate >", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateGreaterThanOrEqualTo(Date value) {
            addCriterion("birthdate >=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThan(Date value) {
            addCriterion("birthdate <", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateLessThanOrEqualTo(Date value) {
            addCriterion("birthdate <=", value, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateIn(List<Date> values) {
            addCriterion("birthdate in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotIn(List<Date> values) {
            addCriterion("birthdate not in", values, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateBetween(Date value1, Date value2) {
            addCriterion("birthdate between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andBirthdateNotBetween(Date value1, Date value2) {
            addCriterion("birthdate not between", value1, value2, "birthdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateIsNull() {
            addCriterion("pbspdate is null");
            return (Criteria) this;
        }

        public Criteria andPbspdateIsNotNull() {
            addCriterion("pbspdate is not null");
            return (Criteria) this;
        }

        public Criteria andPbspdateEqualTo(Date value) {
            addCriterion("pbspdate =", value, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateNotEqualTo(Date value) {
            addCriterion("pbspdate <>", value, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateGreaterThan(Date value) {
            addCriterion("pbspdate >", value, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateGreaterThanOrEqualTo(Date value) {
            addCriterion("pbspdate >=", value, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateLessThan(Date value) {
            addCriterion("pbspdate <", value, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateLessThanOrEqualTo(Date value) {
            addCriterion("pbspdate <=", value, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateIn(List<Date> values) {
            addCriterion("pbspdate in", values, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateNotIn(List<Date> values) {
            addCriterion("pbspdate not in", values, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateBetween(Date value1, Date value2) {
            addCriterion("pbspdate between", value1, value2, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andPbspdateNotBetween(Date value1, Date value2) {
            addCriterion("pbspdate not between", value1, value2, "pbspdate");
            return (Criteria) this;
        }

        public Criteria andComppdateIsNull() {
            addCriterion("comppdate is null");
            return (Criteria) this;
        }

        public Criteria andComppdateIsNotNull() {
            addCriterion("comppdate is not null");
            return (Criteria) this;
        }

        public Criteria andComppdateEqualTo(Date value) {
            addCriterion("comppdate =", value, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateNotEqualTo(Date value) {
            addCriterion("comppdate <>", value, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateGreaterThan(Date value) {
            addCriterion("comppdate >", value, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateGreaterThanOrEqualTo(Date value) {
            addCriterion("comppdate >=", value, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateLessThan(Date value) {
            addCriterion("comppdate <", value, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateLessThanOrEqualTo(Date value) {
            addCriterion("comppdate <=", value, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateIn(List<Date> values) {
            addCriterion("comppdate in", values, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateNotIn(List<Date> values) {
            addCriterion("comppdate not in", values, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateBetween(Date value1, Date value2) {
            addCriterion("comppdate between", value1, value2, "comppdate");
            return (Criteria) this;
        }

        public Criteria andComppdateNotBetween(Date value1, Date value2) {
            addCriterion("comppdate not between", value1, value2, "comppdate");
            return (Criteria) this;
        }

        public Criteria andIscompactIsNull() {
            addCriterion("iscompact is null");
            return (Criteria) this;
        }

        public Criteria andIscompactIsNotNull() {
            addCriterion("iscompact is not null");
            return (Criteria) this;
        }

        public Criteria andIscompactEqualTo(Integer value) {
            addCriterion("iscompact =", value, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactNotEqualTo(Integer value) {
            addCriterion("iscompact <>", value, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactGreaterThan(Integer value) {
            addCriterion("iscompact >", value, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactGreaterThanOrEqualTo(Integer value) {
            addCriterion("iscompact >=", value, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactLessThan(Integer value) {
            addCriterion("iscompact <", value, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactLessThanOrEqualTo(Integer value) {
            addCriterion("iscompact <=", value, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactIn(List<Integer> values) {
            addCriterion("iscompact in", values, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactNotIn(List<Integer> values) {
            addCriterion("iscompact not in", values, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactBetween(Integer value1, Integer value2) {
            addCriterion("iscompact between", value1, value2, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIscompactNotBetween(Integer value1, Integer value2) {
            addCriterion("iscompact not between", value1, value2, "iscompact");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetIsNull() {
            addCriterion("isnowtarget is null");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetIsNotNull() {
            addCriterion("isnowtarget is not null");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetEqualTo(Integer value) {
            addCriterion("isnowtarget =", value, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetNotEqualTo(Integer value) {
            addCriterion("isnowtarget <>", value, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetGreaterThan(Integer value) {
            addCriterion("isnowtarget >", value, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetGreaterThanOrEqualTo(Integer value) {
            addCriterion("isnowtarget >=", value, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetLessThan(Integer value) {
            addCriterion("isnowtarget <", value, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetLessThanOrEqualTo(Integer value) {
            addCriterion("isnowtarget <=", value, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetIn(List<Integer> values) {
            addCriterion("isnowtarget in", values, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetNotIn(List<Integer> values) {
            addCriterion("isnowtarget not in", values, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetBetween(Integer value1, Integer value2) {
            addCriterion("isnowtarget between", value1, value2, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andIsnowtargetNotBetween(Integer value1, Integer value2) {
            addCriterion("isnowtarget not between", value1, value2, "isnowtarget");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andLeavedateIsNull() {
            addCriterion("leavedate is null");
            return (Criteria) this;
        }

        public Criteria andLeavedateIsNotNull() {
            addCriterion("leavedate is not null");
            return (Criteria) this;
        }

        public Criteria andLeavedateEqualTo(Date value) {
            addCriterion("leavedate =", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateNotEqualTo(Date value) {
            addCriterion("leavedate <>", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateGreaterThan(Date value) {
            addCriterion("leavedate >", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateGreaterThanOrEqualTo(Date value) {
            addCriterion("leavedate >=", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateLessThan(Date value) {
            addCriterion("leavedate <", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateLessThanOrEqualTo(Date value) {
            addCriterion("leavedate <=", value, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateIn(List<Date> values) {
            addCriterion("leavedate in", values, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateNotIn(List<Date> values) {
            addCriterion("leavedate not in", values, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateBetween(Date value1, Date value2) {
            addCriterion("leavedate between", value1, value2, "leavedate");
            return (Criteria) this;
        }

        public Criteria andLeavedateNotBetween(Date value1, Date value2) {
            addCriterion("leavedate not between", value1, value2, "leavedate");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNull() {
            addCriterion("nativeplace is null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNotNull() {
            addCriterion("nativeplace is not null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceEqualTo(String value) {
            addCriterion("nativeplace =", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotEqualTo(String value) {
            addCriterion("nativeplace <>", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThan(String value) {
            addCriterion("nativeplace >", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThanOrEqualTo(String value) {
            addCriterion("nativeplace >=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThan(String value) {
            addCriterion("nativeplace <", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThanOrEqualTo(String value) {
            addCriterion("nativeplace <=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLike(String value) {
            addCriterion("nativeplace like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotLike(String value) {
            addCriterion("nativeplace not like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIn(List<String> values) {
            addCriterion("nativeplace in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotIn(List<String> values) {
            addCriterion("nativeplace not in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceBetween(String value1, String value2) {
            addCriterion("nativeplace between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotBetween(String value1, String value2) {
            addCriterion("nativeplace not between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andAlnatureIsNull() {
            addCriterion("alnature is null");
            return (Criteria) this;
        }

        public Criteria andAlnatureIsNotNull() {
            addCriterion("alnature is not null");
            return (Criteria) this;
        }

        public Criteria andAlnatureEqualTo(String value) {
            addCriterion("alnature =", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureNotEqualTo(String value) {
            addCriterion("alnature <>", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureGreaterThan(String value) {
            addCriterion("alnature >", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureGreaterThanOrEqualTo(String value) {
            addCriterion("alnature >=", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureLessThan(String value) {
            addCriterion("alnature <", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureLessThanOrEqualTo(String value) {
            addCriterion("alnature <=", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureLike(String value) {
            addCriterion("alnature like", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureNotLike(String value) {
            addCriterion("alnature not like", value, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureIn(List<String> values) {
            addCriterion("alnature in", values, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureNotIn(List<String> values) {
            addCriterion("alnature not in", values, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureBetween(String value1, String value2) {
            addCriterion("alnature between", value1, value2, "alnature");
            return (Criteria) this;
        }

        public Criteria andAlnatureNotBetween(String value1, String value2) {
            addCriterion("alnature not between", value1, value2, "alnature");
            return (Criteria) this;
        }

        public Criteria andEdubgIsNull() {
            addCriterion("edubg is null");
            return (Criteria) this;
        }

        public Criteria andEdubgIsNotNull() {
            addCriterion("edubg is not null");
            return (Criteria) this;
        }

        public Criteria andEdubgEqualTo(String value) {
            addCriterion("edubg =", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgNotEqualTo(String value) {
            addCriterion("edubg <>", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgGreaterThan(String value) {
            addCriterion("edubg >", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgGreaterThanOrEqualTo(String value) {
            addCriterion("edubg >=", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgLessThan(String value) {
            addCriterion("edubg <", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgLessThanOrEqualTo(String value) {
            addCriterion("edubg <=", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgLike(String value) {
            addCriterion("edubg like", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgNotLike(String value) {
            addCriterion("edubg not like", value, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgIn(List<String> values) {
            addCriterion("edubg in", values, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgNotIn(List<String> values) {
            addCriterion("edubg not in", values, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgBetween(String value1, String value2) {
            addCriterion("edubg between", value1, value2, "edubg");
            return (Criteria) this;
        }

        public Criteria andEdubgNotBetween(String value1, String value2) {
            addCriterion("edubg not between", value1, value2, "edubg");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeIsNull() {
            addCriterion("isfulltime is null");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeIsNotNull() {
            addCriterion("isfulltime is not null");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeEqualTo(Integer value) {
            addCriterion("isfulltime =", value, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeNotEqualTo(Integer value) {
            addCriterion("isfulltime <>", value, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeGreaterThan(Integer value) {
            addCriterion("isfulltime >", value, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("isfulltime >=", value, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeLessThan(Integer value) {
            addCriterion("isfulltime <", value, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeLessThanOrEqualTo(Integer value) {
            addCriterion("isfulltime <=", value, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeIn(List<Integer> values) {
            addCriterion("isfulltime in", values, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeNotIn(List<Integer> values) {
            addCriterion("isfulltime not in", values, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeBetween(Integer value1, Integer value2) {
            addCriterion("isfulltime between", value1, value2, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andIsfulltimeNotBetween(Integer value1, Integer value2) {
            addCriterion("isfulltime not between", value1, value2, "isfulltime");
            return (Criteria) this;
        }

        public Criteria andDepositbankIsNull() {
            addCriterion("depositbank is null");
            return (Criteria) this;
        }

        public Criteria andDepositbankIsNotNull() {
            addCriterion("depositbank is not null");
            return (Criteria) this;
        }

        public Criteria andDepositbankEqualTo(String value) {
            addCriterion("depositbank =", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankNotEqualTo(String value) {
            addCriterion("depositbank <>", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankGreaterThan(String value) {
            addCriterion("depositbank >", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankGreaterThanOrEqualTo(String value) {
            addCriterion("depositbank >=", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankLessThan(String value) {
            addCriterion("depositbank <", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankLessThanOrEqualTo(String value) {
            addCriterion("depositbank <=", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankLike(String value) {
            addCriterion("depositbank like", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankNotLike(String value) {
            addCriterion("depositbank not like", value, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankIn(List<String> values) {
            addCriterion("depositbank in", values, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankNotIn(List<String> values) {
            addCriterion("depositbank not in", values, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankBetween(String value1, String value2) {
            addCriterion("depositbank between", value1, value2, "depositbank");
            return (Criteria) this;
        }

        public Criteria andDepositbankNotBetween(String value1, String value2) {
            addCriterion("depositbank not between", value1, value2, "depositbank");
            return (Criteria) this;
        }

        public Criteria andBankcardIsNull() {
            addCriterion("bankcard is null");
            return (Criteria) this;
        }

        public Criteria andBankcardIsNotNull() {
            addCriterion("bankcard is not null");
            return (Criteria) this;
        }

        public Criteria andBankcardEqualTo(String value) {
            addCriterion("bankcard =", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotEqualTo(String value) {
            addCriterion("bankcard <>", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardGreaterThan(String value) {
            addCriterion("bankcard >", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardGreaterThanOrEqualTo(String value) {
            addCriterion("bankcard >=", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardLessThan(String value) {
            addCriterion("bankcard <", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardLessThanOrEqualTo(String value) {
            addCriterion("bankcard <=", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardLike(String value) {
            addCriterion("bankcard like", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotLike(String value) {
            addCriterion("bankcard not like", value, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardIn(List<String> values) {
            addCriterion("bankcard in", values, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotIn(List<String> values) {
            addCriterion("bankcard not in", values, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardBetween(String value1, String value2) {
            addCriterion("bankcard between", value1, value2, "bankcard");
            return (Criteria) this;
        }

        public Criteria andBankcardNotBetween(String value1, String value2) {
            addCriterion("bankcard not between", value1, value2, "bankcard");
            return (Criteria) this;
        }

        public Criteria andContactsIsNull() {
            addCriterion("contacts is null");
            return (Criteria) this;
        }

        public Criteria andContactsIsNotNull() {
            addCriterion("contacts is not null");
            return (Criteria) this;
        }

        public Criteria andContactsEqualTo(String value) {
            addCriterion("contacts =", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotEqualTo(String value) {
            addCriterion("contacts <>", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThan(String value) {
            addCriterion("contacts >", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsGreaterThanOrEqualTo(String value) {
            addCriterion("contacts >=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThan(String value) {
            addCriterion("contacts <", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLessThanOrEqualTo(String value) {
            addCriterion("contacts <=", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsLike(String value) {
            addCriterion("contacts like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotLike(String value) {
            addCriterion("contacts not like", value, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsIn(List<String> values) {
            addCriterion("contacts in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotIn(List<String> values) {
            addCriterion("contacts not in", values, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsBetween(String value1, String value2) {
            addCriterion("contacts between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andContactsNotBetween(String value1, String value2) {
            addCriterion("contacts not between", value1, value2, "contacts");
            return (Criteria) this;
        }

        public Criteria andRankidIsNull() {
            addCriterion("rankid is null");
            return (Criteria) this;
        }

        public Criteria andRankidIsNotNull() {
            addCriterion("rankid is not null");
            return (Criteria) this;
        }

        public Criteria andRankidEqualTo(Integer value) {
            addCriterion("rankid =", value, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidNotEqualTo(Integer value) {
            addCriterion("rankid <>", value, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidGreaterThan(Integer value) {
            addCriterion("rankid >", value, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidGreaterThanOrEqualTo(Integer value) {
            addCriterion("rankid >=", value, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidLessThan(Integer value) {
            addCriterion("rankid <", value, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidLessThanOrEqualTo(Integer value) {
            addCriterion("rankid <=", value, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidIn(List<Integer> values) {
            addCriterion("rankid in", values, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidNotIn(List<Integer> values) {
            addCriterion("rankid not in", values, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidBetween(Integer value1, Integer value2) {
            addCriterion("rankid between", value1, value2, "rankid");
            return (Criteria) this;
        }

        public Criteria andRankidNotBetween(Integer value1, Integer value2) {
            addCriterion("rankid not between", value1, value2, "rankid");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNull() {
            addCriterion("positionid is null");
            return (Criteria) this;
        }

        public Criteria andPositionidIsNotNull() {
            addCriterion("positionid is not null");
            return (Criteria) this;
        }

        public Criteria andPositionidEqualTo(Integer value) {
            addCriterion("positionid =", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotEqualTo(Integer value) {
            addCriterion("positionid <>", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThan(Integer value) {
            addCriterion("positionid >", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidGreaterThanOrEqualTo(Integer value) {
            addCriterion("positionid >=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThan(Integer value) {
            addCriterion("positionid <", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidLessThanOrEqualTo(Integer value) {
            addCriterion("positionid <=", value, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidIn(List<Integer> values) {
            addCriterion("positionid in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotIn(List<Integer> values) {
            addCriterion("positionid not in", values, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidBetween(Integer value1, Integer value2) {
            addCriterion("positionid between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPositionidNotBetween(Integer value1, Integer value2) {
            addCriterion("positionid not between", value1, value2, "positionid");
            return (Criteria) this;
        }

        public Criteria andPostidIsNull() {
            addCriterion("postid is null");
            return (Criteria) this;
        }

        public Criteria andPostidIsNotNull() {
            addCriterion("postid is not null");
            return (Criteria) this;
        }

        public Criteria andPostidEqualTo(Integer value) {
            addCriterion("postid =", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotEqualTo(Integer value) {
            addCriterion("postid <>", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThan(Integer value) {
            addCriterion("postid >", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidGreaterThanOrEqualTo(Integer value) {
            addCriterion("postid >=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThan(Integer value) {
            addCriterion("postid <", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidLessThanOrEqualTo(Integer value) {
            addCriterion("postid <=", value, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidIn(List<Integer> values) {
            addCriterion("postid in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotIn(List<Integer> values) {
            addCriterion("postid not in", values, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidBetween(Integer value1, Integer value2) {
            addCriterion("postid between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andPostidNotBetween(Integer value1, Integer value2) {
            addCriterion("postid not between", value1, value2, "postid");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(Integer value) {
            addCriterion("roleid =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(Integer value) {
            addCriterion("roleid <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(Integer value) {
            addCriterion("roleid >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(Integer value) {
            addCriterion("roleid >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(Integer value) {
            addCriterion("roleid <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(Integer value) {
            addCriterion("roleid <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<Integer> values) {
            addCriterion("roleid in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<Integer> values) {
            addCriterion("roleid not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(Integer value1, Integer value2) {
            addCriterion("roleid between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(Integer value1, Integer value2) {
            addCriterion("roleid not between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsstatusIsNull() {
            addCriterion("isstatus is null");
            return (Criteria) this;
        }

        public Criteria andIsstatusIsNotNull() {
            addCriterion("isstatus is not null");
            return (Criteria) this;
        }

        public Criteria andIsstatusEqualTo(Integer value) {
            addCriterion("isstatus =", value, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusNotEqualTo(Integer value) {
            addCriterion("isstatus <>", value, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusGreaterThan(Integer value) {
            addCriterion("isstatus >", value, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("isstatus >=", value, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusLessThan(Integer value) {
            addCriterion("isstatus <", value, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusLessThanOrEqualTo(Integer value) {
            addCriterion("isstatus <=", value, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusIn(List<Integer> values) {
            addCriterion("isstatus in", values, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusNotIn(List<Integer> values) {
            addCriterion("isstatus not in", values, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusBetween(Integer value1, Integer value2) {
            addCriterion("isstatus between", value1, value2, "isstatus");
            return (Criteria) this;
        }

        public Criteria andIsstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("isstatus not between", value1, value2, "isstatus");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNull() {
            addCriterion("companyid is null");
            return (Criteria) this;
        }

        public Criteria andCompanyidIsNotNull() {
            addCriterion("companyid is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyidEqualTo(Integer value) {
            addCriterion("companyid =", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotEqualTo(Integer value) {
            addCriterion("companyid <>", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThan(Integer value) {
            addCriterion("companyid >", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidGreaterThanOrEqualTo(Integer value) {
            addCriterion("companyid >=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThan(Integer value) {
            addCriterion("companyid <", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidLessThanOrEqualTo(Integer value) {
            addCriterion("companyid <=", value, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidIn(List<Integer> values) {
            addCriterion("companyid in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotIn(List<Integer> values) {
            addCriterion("companyid not in", values, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidBetween(Integer value1, Integer value2) {
            addCriterion("companyid between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andCompanyidNotBetween(Integer value1, Integer value2) {
            addCriterion("companyid not between", value1, value2, "companyid");
            return (Criteria) this;
        }

        public Criteria andNewsecurityIsNull() {
            addCriterion("newsecurity is null");
            return (Criteria) this;
        }

        public Criteria andNewsecurityIsNotNull() {
            addCriterion("newsecurity is not null");
            return (Criteria) this;
        }

        public Criteria andNewsecurityEqualTo(Integer value) {
            addCriterion("newsecurity =", value, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityNotEqualTo(Integer value) {
            addCriterion("newsecurity <>", value, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityGreaterThan(Integer value) {
            addCriterion("newsecurity >", value, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityGreaterThanOrEqualTo(Integer value) {
            addCriterion("newsecurity >=", value, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityLessThan(Integer value) {
            addCriterion("newsecurity <", value, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityLessThanOrEqualTo(Integer value) {
            addCriterion("newsecurity <=", value, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityIn(List<Integer> values) {
            addCriterion("newsecurity in", values, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityNotIn(List<Integer> values) {
            addCriterion("newsecurity not in", values, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityBetween(Integer value1, Integer value2) {
            addCriterion("newsecurity between", value1, value2, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andNewsecurityNotBetween(Integer value1, Integer value2) {
            addCriterion("newsecurity not between", value1, value2, "newsecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityIsNull() {
            addCriterion("issecurity is null");
            return (Criteria) this;
        }

        public Criteria andIssecurityIsNotNull() {
            addCriterion("issecurity is not null");
            return (Criteria) this;
        }

        public Criteria andIssecurityEqualTo(Integer value) {
            addCriterion("issecurity =", value, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityNotEqualTo(Integer value) {
            addCriterion("issecurity <>", value, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityGreaterThan(Integer value) {
            addCriterion("issecurity >", value, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityGreaterThanOrEqualTo(Integer value) {
            addCriterion("issecurity >=", value, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityLessThan(Integer value) {
            addCriterion("issecurity <", value, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityLessThanOrEqualTo(Integer value) {
            addCriterion("issecurity <=", value, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityIn(List<Integer> values) {
            addCriterion("issecurity in", values, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityNotIn(List<Integer> values) {
            addCriterion("issecurity not in", values, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityBetween(Integer value1, Integer value2) {
            addCriterion("issecurity between", value1, value2, "issecurity");
            return (Criteria) this;
        }

        public Criteria andIssecurityNotBetween(Integer value1, Integer value2) {
            addCriterion("issecurity not between", value1, value2, "issecurity");
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