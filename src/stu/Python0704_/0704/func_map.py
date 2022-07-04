'''
내장함수 map()

map() 은 첫번째 인수로 함수를 지정(함수 이름을 작성)하고, 두 번째 인수로 
리스트를 지정하면 해당 리스트 내부 요소 값을 일괄적으로 첫번째 인수로 지정한 함수에 인수로 전달
'''

#3개의 숫자 중 최대 값을 판별하여 리턴하는 함수를 정의 
def max_of_three(n1,n2,n3):
    if n1 >n2:
        if n1>n3:
            return n1
        else:
            return n3
    else:
        if n2>n3:
            return n2
        else:
            return n3

'''
n1=int(input('정수1:'))
n2=int(input('정수2:'))
n3=int(input('정수3:'))
'''

n1,n2,n3=map(int,input('정수 3개를 공백으로 구분해서 입력하세요:').split())
#첫번째 매개값은 일괄적으로 적용할 함수 
#두번째는 리스트 지정한다 -> 여기서 split의 결과가 [ 1,2,3] 이런식으로 나온다
#이때 리스트의 내부가 str자료형이라서 여기에 일괄적으로 int함수가 적용된다
#언패키징을 통해 n1,n2,n3에 값을 저장한다.

print('최대 값 :',max_of_three(n1,n2,n3))


def triple_square(number):
    return number**3

li=[2,4,6,8,10]


# map(함수 , 리스트)  ->리스트 내부 요소를 함수로 일괄 전달
#여러개의 데이터를 한번에 다른 형태로 변환하기 위해서 사용

#li 안에 잇는 모든 데이터들을 , tripe_square함수로 전달해서 
#값을 변환하기 위해 사용 
#map함수가 리턴하는 객체를 list로 변환해서 확인  : map이리난 함수는 객체를 결과값으로 리턴해줌 
result=list(map(triple_square,li))
print(result)