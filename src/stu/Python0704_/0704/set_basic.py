'''

집합(set)

-집합은 여러 값들의 모임이며 , 저장 순서가  보장되지 않고 
중복갑스이 저장을 허용하지 않습니다.

집합은 사전과 마찬가지로 {  } 로 표현하지만 , key:value 쌍이 아닌
데이터가 하나씩 들어간다는 점이 사전과 다름

-set() 함수는 공집합을 만들기도 하며, 다른 컬렉션 자료형을
집합 형태로 변활할 수 있다.

#  리스트는    [ ], list( ) 로 빈 리스트 선언 

튜플은 tuple() 로만 빈 튜플 선언
사전은  {}  ,dict()  으로 빈 사전 자료형 서언
집합은 set()으로만 빈 집합 선언 
'''

names={'홍길동','김철수','박영희','고길동','홍길동'}

print(type(names))
print(names)

for x in names:
    if x=='김철수':
        print(x)
        break

#내장함수 set()
s=set()
print(type(s))
print(s)

s1='programming'
print(set(s1))
print(list(s1))
print(tuple(s1))

'''
집합은 변경 가능한 자료형이어서 언제든지 데이터를 
편집할 수 있습니다.

-집합에 요소를 추가할 때 add() 메서드 , 
제거할 때 remove()메서드 사용
'''
print('-'*40)

asia={'korea','china','japan'}
print(asia)

asia.add('thailand')
asia.add('china')
asia.remove('japan')
print(asia)

#집합의 결합은 update() 메서드를 사용합니다(덧셈 연산 XXXX)
asia2={'singapore','indonesia','korea'}
#print(asia+asia2) XXXXXX
asia.update(asia2)
print(asia)
