WITH RECURSIVE GET_HOUR AS( -- 여기서 HOUR가 임시 테이블의 이름이다.
    SELECT 0 AS hour -- 재귀 초깃값
    UNION ALL
    SELECT hour + 1 FROM GET_HOUR -- 재귀를 통해 반복문을 구현. 
    WHERE hour <  23 ) -- 재귀 정지 조건 명시

SELECT G.hour, IFNULL(COUNT(ANIMAL_ID),0) AS COUNT
FROM GET_HOUR G
LEFT OUTER JOIN ANIMAL_OUTS A ON G.HOUR = HOUR(DATETIME)
GROUP BY G.hour
ORDER BY G.hour

-- 




-- point
# SELECT HOUR(DATETIME) AS HOUR, COUNT(*) AS COUNT
# FROM ANIMAL_OUTS
# GROUP BY HOUR
# ORDER BY HOUR
# 이렇게 하면 COUNT가 0인 경우에 대해서는 출력이 안됨.
# 여기서 했어야 하는 대처는 SELCT *을 해서 판단을 한번 했어야 했다
# 결과값에는 0시부터 23시까지 나타나야 한다고 돼있는데, 테이블을 직접 보니 0시부터 23시까지 몇몇 레코드가 없다. 
# 새로운 HOUR에 대해 표를 만들어서 JOIN해야 한다는 것을 알 수 있다.