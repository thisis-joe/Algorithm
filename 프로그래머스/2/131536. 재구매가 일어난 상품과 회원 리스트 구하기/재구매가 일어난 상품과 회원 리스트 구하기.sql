-- 동일한 회원이 동일한 상품을 재구매
-- 하나의 칼럼이 어떻다 하는 문제가 아니라 두 칼럼을 비교해야하는 문제

SELECT USER_ID, PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*)>=2
ORDER BY USER_ID, PRODUCT_ID DESC