package com.act21.impaktapps.rule.engine.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** Public entity used by the real generated Java rules in RegisteredFunctionsTest. */
public class RegisteredFunctionFact {
    private String text = "abc";
    private Long number = 6L;
    private Integer smallNumber = 2;
    private Date startDate;
    private Date endDate;
    private Long result;
    private String output;
    private BigDecimal decimal;
    private Boolean flag;
    private List<String> values = new ArrayList<>();
    private List<Long> numbers = new ArrayList<>();

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public Long getNumber() { return number; }
    public void setNumber(Long number) { this.number = number; }
    public Integer getSmallNumber() { return smallNumber; }
    public void setSmallNumber(Integer smallNumber) { this.smallNumber = smallNumber; }
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    public Long getResult() { return result; }
    public void setResult(Long result) { this.result = result; }
    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
    public BigDecimal getDecimal() { return decimal; }
    public void setDecimal(BigDecimal decimal) { this.decimal = decimal; }
    public Boolean getFlag() { return flag; }
    public void setFlag(Boolean flag) { this.flag = flag; }
    public List<String> getValues() { return values; }
    public void setValues(List<String> values) { this.values = values; }
    public List<Long> getNumbers() { return numbers; }
    public void setNumbers(List<Long> numbers) { this.numbers = numbers; }
}
