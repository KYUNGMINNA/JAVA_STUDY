

//게임에 필요한 데이터 객체 
const gameData={
    secret : Math.floor(Math.random()*100)+1,
    answer :null ,//사용자가 클릭한 숫자.
    min:1,
    max:100
};

//숫자 아이콘 생성 함수 
function makeNumberIcons(){
    //id=numbers 태그 안에다가 숫자 아이콘을 배치해 주세요.
    //숫자 아이콘의 개수는 객체의 min, max에 따라 달라집니다.
    //숫자 아이콘은 div태그이고 클래스 이름이 icon입니다.
    //리턴값은 id=numbers 태그 요소입니다.


    const $numbers=document.getElementById('numbers');
    const $frag=document.createDocumentFragment();

    for(let i=gameData.min;i<=gameData.max;i++){
        const $icon=document.createElement('div');
        $icon.classList.add('icon');
        $icon.textContent=i;
        $frag.appendChild($icon);


    }
    $numbers.appendChild($frag);
    return $numbers;
}


//아이콘 전체 삭제 함수 정의
function clearNumberIcons($numbers){
  
    
    for(let $icon of [...$numbers.children]){
  
        $numbers.removeChild($icon);
    }
}

// up , down 애니메이션을 작동 시킬 클래스 추가 /제거 함수 정의
function executeUpDownAnimation(isUp){
                                            //isup이 true면 select추가 ,false면 삭제
    document.getElementById('up').classList.toggle('selected',isUp);

                                                //  !isUp이  true면 제거, false면 selected추가
    document.getElementById('down').classList.toggle('selected',!isUp);
}


//정답을 맞췄을 때 처리를 수행할 함수 정의
function processCorrect($target){
    //축하 메시지 박스를 나타내게 하는 코드 
    const $finish=document.getElementById('finish');

    //finish박스는 평소에 숨겨져 있음 .이제 드러나도 된다는 신호를 주기위해 클래스 이름을 추가
    $finish.classList.add('show');


    //정답 아이콘을 움직이게 하는 코드
    $target.setAttribute('id','move');
}




//정답을 판별해 주는 함수 정의
function checkAnswer($numbers,$target){
    //객체에서 정답과 사용자의 선택값 가져오기
    const {secret,answer}=gameData;
    console.log(secret);
    const $begin=document.getElementById('begin');
    const $end=document.getElementById('end');

    //정답을 맞췄을 시 정답 처리하는 함수 호출 (processCorrect)
    //up 또는 down일 경우 min과 max값을 변경하고 
    // executeUpDownAnimation함수 호출
    if(secret===answer){
        processCorrect($target);
        return;
    }else if(secret <answer){
        //down일 경우
        gameData.max=answer-1;
        $end.textContent=answer;
        executeUpDownAnimation(false);
    }else{
        //up인 경우 
        gameData.min=answer+1;
        $begin.textContent=answer;
        executeUpDownAnimation(true);
    }

 

    //판별 후에는 아이콘을 재 배채
    clearNumberIcons($numbers); //현재 렌더링 되어 있는 아이콘들을 전체 삭제
    makeNumberIcons(); // min,max가 변경되어 있기 때문에 그에 맞춰서 아이콘을 다시 배치

}




//핵심 실행 로직 즉시 실행 (main 역할)
(function(){
    //div id=nubers 태그가 리턴
    const $numbers=makeNumberIcons();

    //숫자 아이콘을 클릭했을 대의 이벤트(부모 요소에 이벤트 설정해서 전파 )
    $numbers.addEventListener('click',e=>{
        
        if(!e.target.matches('#numbers >.icon')){
            return;
        }
        console.log(`${e.target.textContent}클릭됨!`);

        gameData.answer=+e.target.textContent; // +를 붙여 정수로 바꿔서 대입

        //정답 체크 함수 호출!
        checkAnswer($numbers,e.target);

    });


})();