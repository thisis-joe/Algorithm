-- USED_GOODS_BOARD 
-- BOARD_ID, WRITER_ID, TITLE, CONTENTS, PRICE, CREATED_DATE, STATUS, VIEWS
-- 게시글 ID, 작성자 ID, 게시글 제목, 게시글 내용, 가격, 작성일, 거래상태, 조회수를 의미합니다

-- USED_GOODS_REPLY
-- REPLY_ID, BOARD_ID, WRITER_ID, CONTENTS, CREATED_DATE
-- 댓글 ID, 게시글 ID, 작성자 ID, 댓글 내용, 작성일

-- 2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문

SELECT 
    A.TITLE, 
    A.BOARD_ID, 
    B.REPLY_ID, 
    B.WRITER_ID, 
    B.CONTENTS, 
    TO_CHAR(B.CREATED_DATE,'YYYY-MM-DD') AS CREATED_DATE
FROM USED_GOODS_BOARD A
JOIN USED_GOODS_REPLY B
ON A.BOARD_ID = B.BOARD_ID
WHERE
    EXTRACT(YEAR FROM A.CREATED_DATE) = 2022
    AND
    EXTRACT(MONTH FROM A.CREATED_DATE) = 10
ORDER BY
    B.CREATED_DATE,
    A.TITLE
    
    
-- 어디서부터 조인되었고 안되었는지 모르겠음. JOIN-ON 다음에는 A로 참조하면 조인된 테이블을 참조하는 것인가? SELECT는 그럼 조인 안된?