'''
논리 연산자 ( &, | , and , or , not )


# &,and  연산자는 좌항과 우항이 논리값이 모두 True일 경우에만 전체 결과를 True로 


'''
a=6
if a>1 and a<10:
    print('a는 1보다 크고 10보다 작습니다')
else:
    print('a는 1~10사이의 숫자가 아님')


#파이썬은 위의 식을 연결해서도 작성할 수 있습니다

if 1<a<10:
    print('ok')

'''
 |,or 연산자느 좌항과 우항의 논리 갑싱 한 쪽만 True여도 전체 결과를 Ture로 
'''

'''
단축 평가 연산 (short circuit operate : and ,or )
- 좌항에서 전체 결과가 판명났을 경우
우항 연산을 진행하지 않는 연산자 
'''

c=0   ## or이라서 왼쪽 참이면 다 참이라고 생각해서 오른쪽 이 오류가 발생하더라도 참이 됌
if (c ==0) or (10/c ==5):
    print('통과')

# not 연산자는 논리값을 반전시킴
d=False
if not d:
    print('반점됨')

apple=0
if not apple:
    print('사과가 하나도 없습니다.')
else:
    print('사과가 ',apple,'개 있습니다.')

