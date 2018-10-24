package SpeechToText;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;

/**
 * this class capture voices and change them into byte[] data
 * 
 */
public class CaptureVoice {
    
    static final int MB = 262144;// 1 MB
    
    private static byte[] data;// to post data, it required be less than 1 MB
    public static byte[] getData() {return data;}
    
    private static  boolean running = false;
    private static  Thread stoper;// thread use to stop the capture
    // record duration, in milliseconds
    static final long CAPTURE_TIME = 6000;  // 6 sec
    
    // the line from which audio data is captured
    private static TargetDataLine line;//using SourceDataLine maybe bestter
 
    
    // Defines an audio format
    static AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;//stereo
        boolean singed = true;//nguyen / so tun nhien
        boolean bigEndian = true;
        return new AudioFormat(sampleRate, sampleSizeInBits, channels, singed, bigEndian);
    }
        
 
    // Captures the sound and record into a WAV file
    private static void start() {//don't call this menthod if from outside this class
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if system supports the data line
            if (!AudioSystem.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format); // 1 megabyte * 4 / 8
            
            line.start();   // start capturing
            
            System.out.println("Start capturing...");
 
             
            int numBytesRead;
            running = true;
            byte[] byteArr = new byte[MB];
            // get voices data as byte[]
            int size = line.read(byteArr, 0, MB);
            data = new byte[size];
            for(int i = 0; i < size; i++){
                data[i] = byteArr[i];
            }//get data from arr to reduce size of data
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish();
    }
 
    // Closes the target data line to finish capturing and recording
    static void finish() {
        System.out.println("done");
        running = false;
        line.stop();
        line.close();
    }
    
    public static void captureRun(){//start capture the voices and limit the the capture time
 
        // creates a new thread that waits for a specified of time before stopping
        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(CAPTURE_TIME);//limit time
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                
                finish();
            }
        });
        // start timming to stop capture
        stopper.start();
        
        // start recording
        start();
    }
}

