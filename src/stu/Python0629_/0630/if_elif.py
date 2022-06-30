
'''
다중 분기 조건문  if ~ elif~else
타 언어에서 else if 로 작성하는 키워드를
파이썬에선 elif로 작성
문법의 의미는 동일

-첫번째 조건식의 결과가 false일 경우 아래에 있는
elif문의 조건식을 새롭게 테스트 하여 해당 조건이 True일 경우
elif에 종속된 코드를 실행하빈다
개수에 제한은 없습니다.
'''
age=int(input('나이 :'))

if age>=20:
    print('성인입니다.')
elif age>=17:
    print('고등학생입니다.')
elif age>=14:
    print('중학생입니다.')
elif age>=8:
    print('초등학생입니다.')
else:
    print('미취학 아동 입니다.')