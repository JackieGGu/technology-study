package cn.jackiegu.feature.java8.stream;

import java.time.LocalDate;

/**
 * stream测试实体类
 *
 * @author JackieGu
 * @date 2021/4/8
 */
public class StreamEntity {

    private Integer id;

    private LocalDate date;

    public StreamEntity() {
    }

    public StreamEntity(Integer id, LocalDate date) {
        this.id = id;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static int compare(StreamEntity a, StreamEntity b) {
        return a.date.compareTo(b.date);
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof StreamEntity) {
            StreamEntity entity = (StreamEntity) obj;
            return this.id.equals(entity.id);
        }
        return false;
    }

    @Override
    public String toString() {
        return "{ID: " + id + ", Date: " + date + "}";
    }
}
