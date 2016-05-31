package rnb.myemotionforme.Events;

import android.app.Activity;
import android.widget.Toast;

public class BackPressButtonActivity {
//�ڷΰ��� ��ư 2ȸ ���� �� ���� (�� �� Ŭ���� �� 2�ʰ� ������ ������ ����)
	
        private long backKeyPressedTime = 0;
        private Toast toast;
        private Activity activity;

       public BackPressButtonActivity(Activity activity) {
                      this.activity = activity;
        }

         public void onBackPressed() {
                       if (isAfter2Seconds()) {
                               backKeyPressedTime = System.currentTimeMillis();
                               toast = Toast.makeText(activity, "\'뒤로\'버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
                               toast.show();
                                return;
                      }
                      if (isBefore2Seconds()) {
                                programShutdown();
                                toast.cancel();
                      }
         }

          private Boolean isAfter2Seconds() {
                  return System.currentTimeMillis() > backKeyPressedTime + 2000;

         }  

          private Boolean isBefore2Seconds() {
                  return System.currentTimeMillis() <= backKeyPressedTime + 2000;

         }

          private void programShutdown() {
                         activity .moveTaskToBack(true);
                         activity .finish();
                         android.os.Process.killProcess(android.os.Process.myPid());
                         System.exit(0);
         }

}
