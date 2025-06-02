--  서울에 위치한 식당들의 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회
--  리뷰 평균점수는 소수점 세 번째 자리에서 반올림
--  평균 점수 기준으로 내림차순, 같으면 즐겨찾기 기준 내림차순
SELECT 
    A.REST_ID, 
    A.REST_NAME, 
    A.FOOD_TYPE, 
    A.FAVORITES, 
    A.ADDRESS, 
    ROUND(AVG(B.REVIEW_SCORE),2) SCORE 
FROM REST_INFO A 
    JOIN REST_REVIEW B ON A.REST_ID = B.REST_ID --틀린부분
WHERE A.ADDRESS LIKE '서울%' -- 틀린부분
GROUP BY A.REST_ID, A.REST_NAME, A.FOOD_TYPE, A.FAVORITES, A.ADDRESS -- AVG와 같은 집계함수 사용시, 반드시 GROUP BY가 있어야 함. 	오라클은 집계 함수가 아닌 컬럼은 반드시 GROUP BY에 명시하라고 강제함.
ORDER BY SCORE DESC, A.FAVORITES DESC