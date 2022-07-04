'''
인수의 기본 값 

파이썬에서는 인수의 기본값을 설정하여 자주 바뀌지 않는
매개값은 기본값으로 처리할 수 있도록 해준다.

'''

def calc_stepsum(begin,end,step=1):
    sum=0
    for n in range(begin,end+1,step):
        sum+=n
    return sum

print(calc_stepsum(1,10))  #step=1로 주었기 때문에 ,값을 지정하지 않아도 기본값 적용 되어서 오류 아님!!
print(calc_stepsum(1,10,2)) #값을 주면 내가 지정한 값 적용


#기본값이 지정된 인수를 오른쪽으로 몰아 줘야 한다 . :기본값 없는거 왼쪽으로!
def calc_sum(end,begin=0,step=1): 
    sum=0
    for n in range(begin,end+1,step):
        sum+=n
    return sum

print(calc_sum(100))  