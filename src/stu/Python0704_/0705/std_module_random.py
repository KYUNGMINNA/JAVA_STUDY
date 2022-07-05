

'''
표준 모듈 random

프로그램이 무작위 동작을 하게 하려면 난수값(랜덤값)이 필요 합니다

랜덤값을 난수라고 부르며 난수를 쉽게 발생시킬 수 있는
함수를 제공하는 모듈이 random모듈입니다.

-random모듈의 random() 함수는 0.0이상 1.0미만의 실수 난수값을 발생

'''
import random as r 

rn=r.random()
#print('랜덤 값 :',rn)


'''
정수 난수는 randint() 함수를 사용

randint()는 인수로 시작 범위와, 끝 범위를 지정
끝 범위도 난수 값에 포함 !!! (미만이 아님 !)
'''

pets=['멍멍이','야옹이','짹쨱이','호랑이','코끼리']

idx=r.randint(0,4) # 미만이 아닌 이하 

print('애완 동물을 뭘 키울 까 ? ',pets[idx])


#choice()  함수는 리스트 내부의 임의의 요소를 랜덤으로 선택하여 리턴
print(' 애완동물 뭘 키울 까 ? ',r.choice(pets))

#shuffle()
print(pets)
r.shuffle(pets)
print(pets)

#sample() 함수는 리스트의 항목 중 n 개를 무작위로 추출하여
#새로운 리스트를 만들어 리턴
#중복값은 자동으로 배제 시키며 , 원본 리스트는 변하지 않습니다.
print('-'*40)
s_list=r.sample(pets,2)
print(s_list)
print(pets)

#sample 함수를 솰용한 로또 번호 6개 뽑기 (중복은 제거 )
lotto_nums=list(range(1,46))
lotto=r.sample(lotto_nums,6)
lotto.sort()
print(lotto)