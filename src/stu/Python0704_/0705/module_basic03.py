
'''

사용자 정의 모듈

하나의 모듈 파일에 너무 많은  코드가 들어 있다면 
편집이 힘들어지고 코드를 유지 보수 하는데 어려움이 발생합니다.

관리 편의상 비슷한 기능을 가진 코드를 여러 개의 모듈에 나누어서
작성하는것이 졷다.
'''

import calculator as cal 

print(f'1인치 :{cal.inch}cm')
print('1부터 10까지의 누적 합 : ',cal.calc_sum(10))

n1,n2=map(int,input('정수 2개 입력 : ').split())
print(f'{n1}+{n2}={cal.add(n1,n2)}')