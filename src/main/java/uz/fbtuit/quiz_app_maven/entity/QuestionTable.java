package uz.fbtuit.quiz_app_maven.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "QuestionTable")
@Table
public class QuestionTable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private static final String sequence = "question_table_sequence";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @Lob
    private String question;
    private String trueValue;
    private String value1;
    private String value2;
    private String value3;

    private Integer userId;

    public QuestionTable(Integer id, String question, String trueValue, String value1, String value2, String value3, Integer userId) {
        this.id = id;
        this.question = question;
        this.trueValue = trueValue;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.userId = userId;
    }

    public QuestionTable() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTrueValue() {
        return trueValue;
    }

    public void setTrueValue(String trueValue) {
        this.trueValue = trueValue;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

}
