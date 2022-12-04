package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    private final String BOARD_INSERT = "insert into BOARD (title, writer, content) values (?,?,?)";
//    private final String BOARD_UPDATE = "update BOARD set title=?, writer=?, content=? where seq=?";
//    private final String BOARD_DELETE = "delete from BOARD  where seq=?";
//    private final String BOARD_GET = "select * from BOARD  where seq=?";
//    private final String BOARD_LIST = "select * from BOARD order by seq desc";

    public int insertBoard(BoardVO vo) {
        String sql = "insert into BOARD (title, writer, content) values (" + "'" + vo.getTitle() + "'," + "'"+vo.getWriter()+"'," + "'"+vo.getContent() + "')";
        return jdbcTemplate.update(sql);
    }

    public int deleteBoard(int seq) {
        String sql = "delete from BOARD where seq = " + seq;
        return jdbcTemplate.update(sql);
    }

    public int updateBoard(BoardVO vo) {
        String sql = "update BOARD set title='" +vo.getTitle() + "'," +
                " title='" + vo.getTitle() + "'," + " writer='" + vo.getWriter() + "'," +
                " content='" + vo.getContent() + "' where seq=" + vo.getSeq();
        return jdbcTemplate.update(sql);
    }

    public BoardVO getBoard(int seq) {
        String sql = "select * from BOARD where seq=" + seq;
        return jdbcTemplate.queryForObject(sql, new BoardRowMapper());
    }

    public List<BoardVO> getBoardList() {
        String sql = "select * from BOARD order by regdate desc";
        System.out.println("hello");
//        List<BoardVO> test = jdbcTemplate.query(sql, new BoardRowMapper());
//        jdbcTemplate.
//        int i = jdbcTemplate.getQueryTimeout();
//        System.out.println(i);
        if(jdbcTemplate == null) {
            System.out.println("ducking null");
        }
        System.out.println("plz work");
        return jdbcTemplate.query(sql, new BoardRowMapper());
    }

    class BoardRowMapper implements RowMapper<BoardVO> {
        @Override
        public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BoardVO vo = new BoardVO();
            vo.setSeq(rs.getInt("seq"));
            vo.setTitle(rs.getString("title"));
            vo.setContent(rs.getString("content"));
            vo.setWriter(rs.getString("writer"));
            vo.setRegdate(rs.getDate("regdate"));
            return vo;
        }
    }
}
