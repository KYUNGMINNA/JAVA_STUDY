package java2.chapter08;

public class ch8_23 {
    public static void main(String[] args) {
        try {
            install();
        }catch (InstallException e){
            e.printStackTrace();
        }catch(Exception e){

        }

    }
    static  void install() throws InstallException{
        try {
            startInstall();
            copyFiles();
        }catch (SpacesException se){
            InstallException ie=new InstallException("설치 중 예외발생");
            ie.initCause(se);
            throw ie;
        }catch (MemorysException me){
            InstallException ie=new InstallException("설치 중 예외발생");
            ie.initCause(me);
            throw ie;

        }finally {
            deleteTempFIles();
        }
    }
    static void startInstall() throws SpacesException,MemorysException{
        if (!enoughSPace()){
            throw new SpacesException("설치할 공간이 부족합니다.");

        }
        if (!enoughMemory()){
            throw new MemorysException("메모리가 부족합니다.");
            //throw new RuntimeException(new MemorysException("메모리가 부족합니다."));

        }
    }

    static void copyFiles(){}
    static void deleteTempFIles(){}
    static boolean enoughSPace(){
        return false;
    }
    static boolean enoughMemory(){
        return true;
    }
}
class InstallException extends Exception{
    InstallException(String msg){
        super(msg);
    }
}
class  SpacesException extends Exception{
    SpacesException(String msg){
        super(msg);
    }
}
class  MemorysException extends Exception{
    MemorysException(String msg){
        super(msg);
    }
}
