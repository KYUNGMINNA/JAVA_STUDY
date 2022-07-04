

'''
함수 function

-함수는 지속적으로 사용되는 코드 블록에 이름을 붙여놓은 형태입니다.

함수는 한번 정의해 두면 지정된 함수 이름을 통해
언제든지 해당 코드 블록을 실행할 수 있습니다.

-함수를 정의할 때 사용하는 키워드는 def 입니다.

정의해 놓은 함수를 사용하는 것을 호출(call)이라고 부릅니다

파이썬에서는 함수를 호출하려면 반드시 호출문보다 상단부에
함수를 먼저 정의해야 합니다.
'''

#함수의 정의 (1~x까지의 누적합을 구하는 로직)

def calc_sum(end):
    sum=0
    for n in range(1,end+1):
        sum+=n
    return sum

#함수의 호출
print('1~100까지의 누적합 :',calc_sum(100))

'''
인수 ,매개변수 

-인수는 함수를 호출할 때 함수 실행에 필요한 값들을 전달하는 매게체 역할을 하며 ,
매개변수(parameter)라고도 부릅니다.

-인수의 개수는 제한이 없어 많은 값을 함수에 전달할 수 도 있고 ,
하나도 전달하지 않을 수 있다.

매개변수 4개정도까지가 적당함 그 개수 이상은 객체로 전달 

-파이썬의 경우에는 데이터 타입을 작성하지 않기 때문에 
이 함수를 처음 사용하는 사람도 인수 이름만 보고 무슨 값을 전달해야 할 지
의므를 알기 쉽게 지정하는 것이 좋습니다.

'''

'''
* 연습

1. 인수를 정수형태로 시작값(start), 끝값(end)을 입력받아
 반복문으로 start부터 end까지의 누적 총합을 구하는 함수를 정의하세요.

2. 함수 이름은 calc_rangesum으로 정의하세요.
ex) calc_rangesum(3, 7) -> 3부터 7까지의 누적합을 구해와야 함.

3. 출력예시: "x~y까지의 누적합: z"
사용자에게 입력받은 값을 함수로 전달해서 값을 출력해 보세요.
'''

start=int(input('시작값:'))
end=int(input('끝 값 :'))

def calc_rangesum(start,end):
    if start>end:
        start,end=end,start  # tuple의 언패키징 
    sum=0
    for x in range(start,end+1):
        sum+=x
    return sum

print(f'{start}~{end}까지의 누적합 :{calc_rangesum(start,end)}')

'''

반환값(return value)

-반환값이란 함수를 호출한 곳으로 함수의 최종 실랭 결과를 전달하는 값 입니다.
return 만 작성할 수도 있는데, 함수 종료 역할을 함 


-인수는 여러개 존재할 수 있지만 ,반환값은 언제나 하나만 존재해야 합니다.

모든 함수가 반환값이 있는 것은 아닙니다
함수 실행 후 딱히 반환할 값이 없다면 return을 생략할 수 있습니다.  :자바로 치면 void메서드 
'''

def add(n1,n2):
    return n1+n2

result=add(10,5)

#리턴이 있는 함수는 다른 함수의 매개값으로 사용이 가능합니다.
print(add(add(5,7),add(9,8)))  # ==add(12,7)


def operat_all(n1,n2):
    return n1+n2,n1-n2,n1*n2,n1/n2   # 괄호 안써서 tuple 로 리턴
    #return n1-n2 
print(type(operat_all(10,5)))


def multi(n1,n2):
    result=n1*n2
    print(f'{n1}x{n2} ={result}')
#abc=multi(9,6)  -> 리턴이 없는 함수의 결과라서 None이 온다 .
#print(abc)