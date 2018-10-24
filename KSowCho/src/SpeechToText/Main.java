package SpeechToText;




public class Main {
    
    public Main()
    {
        
    }
    public String speech()
    {
        SpeechRecognition speechRecognition = new SpeechRecognition();
       
        CaptureVoice.captureRun();
        System.out.println(CaptureVoice.getData().length);
        System.out.println(speechRecognition.getString(CaptureVoice.getData()));
        return speechRecognition.getString(CaptureVoice.getData());
    }
    
    public static void main(String[] args) {
        
    }
}
