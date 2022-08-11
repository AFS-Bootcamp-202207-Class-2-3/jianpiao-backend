package com.jianpiao.api.model.entity;

import com.jianpiao.api.exception.SeatAlreadySoldException;
import com.jianpiao.api.exception.SeatNotExistsException;
import com.jianpiao.api.model.entity.converter.StringToTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_session", schema = "public")
public class Session {

    public static final Character SOLD = '2';
    public static final Character FREE = '1';
    public static final Character NOT_EXIST = '0';

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "film_id", referencedColumnName = "id")
    private Film film;

    @OneToOne
    @JoinColumn(name = "hall_id", referencedColumnName = "id")
    private Hall hall;

    @OneToOne
    @JoinColumn(name = "cinema_id", referencedColumnName = "id")
    private Cinema cinema;

    private Date date;

    @Column(name = "start_time")
    @Convert(
            converter = StringToTimeConverter.class
    )
    private String startTime;

    @Column(name = "end_time")
    @Convert(
            converter = StringToTimeConverter.class
    )
    private String endTime;

    private Double price;

    private String site;

    public List<String> updateSite(List<Integer> seatIndexes, Character operation) {

        char[] chars = site.toCharArray();
        List<String> seats = seatIndexes.stream()
                .map(index -> {
                    int row = index / 11 + 1;
                    int col = index % 11 + 1;
                    if (NOT_EXIST.equals(chars[index])) {
                        throw new SeatNotExistsException();
                    } else if (SOLD.equals(chars[index]) && SOLD.equals(operation)) {
                        throw new SeatAlreadySoldException();
                    }
                    chars[index] = operation;
                    return String.format("%d排%d座", row, col);
                })
                .collect(Collectors.toList());
        setSite(new String(chars));
        return seats;
    }
}
