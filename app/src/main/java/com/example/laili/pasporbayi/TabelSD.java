package com.example.laili.pasporbayi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Laili on 27/05/2017.
 */
public class TabelSD {
    private List<DataSD> listSD;
    private List<DataSD> listSDBBUmur;
    private static TabelSD ourInstance = new TabelSD();
    public static TabelSD getInstance() {
        return ourInstance;
    }

    private TabelSD() {
        listSD = new ArrayList<>();
        listSD.add(new DataSD("perempuan", 0, 0, 0, 3.5, 3.2, 50.8, 49.1, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 1, 0, 4.5, 4.2, 55.4, 53.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 2, 0, 5.4, 5.1, 58.8, 57.1, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 3, 0, 6.1, 5.8, 61.5, 59.8, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 4, 0, 6.7, 6.4, 63.8, 62.1, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 5, 0, 7.2, 6.9, 65.7, 64, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 6, 0, 7.6, 7.3, 67.4, 65.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 7, 0, 7.9, 7.6, 69, 67.3, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 8, 0, 8.2, 7.9, 70.4, 68.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 9, 0, 8.5, 8.2, 71.8, 70.1, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 10, 0, 8.8, 8.5, 73.2, 71.5, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 11, 0, 9, 8.7, 75.5, 72.8, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 0, 0, 9.2, 8.9, 75.7, 74, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 3, 0, 9.9, 9.6, 79.2, 77.5, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 6, 0, 10.5, 10.2, 82.4, 80.7, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 9, 0, 11.2, 10.9, 85.4, 83.7, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 0, 0, 11.8, 11.5, 88.1, 86.4, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 3, 0, 12.4, 12.1, 90, 88.3, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 6, 0, 13, 12.7, 92.4, 90.7, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 9, 0, 13.7, 13.3, 94.6, 92.9, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 0, 0, 14.2, 13.9, 96.8, 95.1, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 3, 0, 14.7, 14.4, 98.8, 97.1, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 6, 0, 15.3, 15, 100.7, 99, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 9, 0, 15.8, 15.5, 101.5, 100.9, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 0, 0, 16.4, 16.1, 104.4, 102.7, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 3, 0, 16.9, 16.6, 106.2, 104.5, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 6, 0, 17.5, 17.2, 107.9, 106.2, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 9, 0, 18, 17.7, 109.5, 107.8, 0, 0));
        listSD.add(new DataSD("perempuan", 5, 0, 0, 7, 18.2, 111.1, 109.4, 0, 0));

        listSD.add(new DataSD("perempuan", 0, 0, -1, 3.1, 2.8, 49, 47.3, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 1, -1, 3.9, 3.6, 53.4, 51.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 2, -1, 4.8, 4.5, 56.7, 55, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 3, -1, 5.5, 5.2, 59.4, 57.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 4, -1, 6, 5.7, 61.6, 59.9, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 5, -1, 6.4, 6.1, 63.5, 61.8, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 6, -1, 6.8, 6.5, 65.2, 63.5, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 7, -1, 7.1, 6.8, 66.7, 65, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 8, -1, 7.4, 7, 68.4, 66.4, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 9, -1, 7.6, 7.3, 69.5, 67.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 10, -1, 7.8, 7.5, 70.7, 69, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 11, -1, 8, 7.7, 71, 70.3, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 0, -1, 8.2, 7.9, 73.1, 71.4, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 3, -1, 8.8, 8.5, 76.5, 74.8, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 6, -1, 9.4, 9.1, 79.5, 77.8, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 9, -1, 9.9, 9.6, 82.3, 80.6, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 0, -1, 10.5, 10.2, 85.9, 83.2, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 3, -1, 11, 10.7, 86.6, 84.9, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 6, -1, 11.5, 11.2, 89.8, 87.1, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 9, -1, 12, 11.7, 91, 89.3, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 0, -1, 12.5, 12.2, 92.9, 91.2, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 3, -1, 13, 12.7, 94.8, 93.1, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 6, -1, 13.4, 13.1, 96.7, 95, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 9, -1, 13.9, 13.6, 98.4, 96.7, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 0, -1, 14.3, 14, 100.1, 98.4, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 3, -1, 14.8, 14.5, 100.8, 100.1, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 6, -1, 15.2, 14.9, 103.3, 101.6, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 9, -1, 15.6, 15.3, 104.9, 103.2, 0, 0));
        listSD.add(new DataSD("perempuan", 5, 0, -1, 16.1, 15.8, 106.4, 104.7, 0, 0));

        listSD.add(new DataSD("perempuan", 0, 0, -2, 2.7, 2.4, 47.1, 45.4, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 1, -2, 3.5, 3.2, 51.5, 49.8, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 2, -2, 4.2, 3.9, 55, 53, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 3, -2, 4.8, 4.5, 57.3, 55.6, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 4, -2, 5.3, 5, 59.5, 57.8, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 5, -2, 5.7, 5.4, 61.3, 59.6, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 6, -2, 6, 5.7, 62.9, 61.2, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 7, -2, 6.3, 6, 64.4, 62.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 8, -2, 6.6, 6.3, 65.7, 64, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 9, -2, 6.8, 6.5, 67, 65.3, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 10, -2, 7, 6.7, 68.2, 66.5, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 11, -2, 7.2, 6.9, 69.4, 67.7, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 0, -2, 7.3, 7, 70.6, 68.9, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 3, -2, 7.9, 7.6, 73.7, 72, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 6, -2, 8.4, 8.1, 76.6, 74.9, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 9, -2, 8.9, 8.6, 79.2, 77.5, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 0, -2, 9.3, 9, 81.7, 80, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 3, -2, 9.8, 9.5, 83.2, 81.5, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 6, -2, 10.3, 10, 85.3, 83.6, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 9, -2, 10.7, 10.4, 87.3, 85.6, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 0, -2, 11.1, 10.8, 89.1, 87.4, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 3, -2, 11.5, 11.2, 90.9, 89.2, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 6, -2, 11.9, 11.6, 92.6, 90.9, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 9, -2, 12.3, 12, 94.2, 92.5, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 0, -2, 12.6, 12.3, 95.8, 94.1, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 3, -2, 13, 12.7, 97.3, 95.6, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 6, -2, 13.3, 13, 98.8, 97.1, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 9, -2, 13.7, 13.4, 100.2, 98.5, 0, 0));
        listSD.add(new DataSD("perempuan", 5, 0, -2, 14, 13.7, 101.6, 99.9, 0, 0));

        listSD.add(new DataSD("perempuan", 0, 0, -3, 2.3, 2, 45.3, 43.6, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 1, -3, 3, 2.7, 49.5, 47.8, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 2, -3, 3.7, 3.4, 52.7, 51, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 3, -3, 4.3, 4, 55.2, 53.5, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 4, -3, 4.7, 4.4, 57.3, 55.6, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 5, -3, 5.1, 4.8, 59.1, 57.4, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 6, -3, 5.4, 5.1, 60.6, 58.9, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 7, -3, 5.7, 5.3, 62, 60.3, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 8, -3, 5.9, 5.6, 63.4, 61.7, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 9, -3, 6.1, 5.8, 64.6, 62.9, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 10, -3, 6.2, 5.9, 66.8, 64.1, 0, 0));
        listSD.add(new DataSD("perempuan", 0, 11, -3, 6.4, 6.1, 66.9, 65.2, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 0, -3, 6.6, 6.3, 68, 66.3, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 3, -3, 7, 6.7, 71, 69.3, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 6, -3, 7.5, 7.2, 73.7, 72, 0, 0));
        listSD.add(new DataSD("perempuan", 1, 9, -3, 7.9, 7.6, 76.2, 74.5, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 0, -3, 8.4, 8.1, 78.4, 76.7, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 3, -3, 8.8, 8.5, 79.8, 78.1, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 6, -3, 9.2, 8.9, 81.8, 80.1, 0, 0));
        listSD.add(new DataSD("perempuan", 2, 9, -3, 9.6, 9.3, 83.6, 81.9, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 0, -3, 9.9, 9.6, 85.3, 83.6, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 3, -3, 10.2, 9.9, 87, 85.3, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 6, -3, 10.6, 10.3, 88.5, 86.8, 0, 0));
        listSD.add(new DataSD("perempuan", 3, 9, -3, 10.9, 10.6, 90.1, 88.4, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 0, -3, 11.2, 10.9, 91.5, 89.8, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 3, -3, 11.5, 11.2, 92.9, 91.2, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 6, -3, 11.8, 11.5, 94.3, 92.6, 0, 0));
        listSD.add(new DataSD("perempuan", 4, 9, -3, 12.1, 11.8, 95.6, 93.9, 0, 0));
        listSD.add(new DataSD("perempuan", 5, 0, -3, 12.4, 12.1, 96.9, 95.2, 0, 0));

        listSD.add(new DataSD("laki-laki", 0, 0, 0, 3.6, 3.3, 51.6, 49.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 1, 0, 4.8, 4.5, 56.4, 54.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 2, 0, 5.9, 5.6, 60.1, 58.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 3, 0, 6.7, 6.4, 63.1, 61.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 4, 0, 7.3, 7, 65.6, 63.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 5, 0, 7.8, 7.5, 67.6, 65.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 6, 0, 8.2, 7.9, 69.3, 67.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 7, 0, 8.6, 8.3, 69.9, 69.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 8, 0, 8.9, 8.6, 72.3, 70.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 9, 0, 9.2, 8.9, 73.7, 72, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 10, 0, 9.5, 9.2, 75, 73.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 11, 0, 9.7, 9.4, 76.2, 74.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 0, 0, 9.9, 9.6, 77.4, 75.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 3, 0, 10.6, 10.3, 80.8, 79.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 6, 0, 11.2, 10.9, 84, 82.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 9, 0, 11.8, 11.5, 87.8, 85.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 0, 0, 12.5, 12.2, 89.5, 87.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 3, 0, 13, 12.7, 91.3, 89.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 6, 0, 13.6, 13.3, 93.6, 91.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 9, 0, 14.1, 13.8, 95.8, 94.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 0, 0, 14.6, 14.3, 97.8, 96.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 3, 0, 15.1, 14.8, 99.7, 98, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 6, 0, 15.6, 15.3, 101.6, 99.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 9, 0, 16.1, 15.8, 103.3, 101.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 0, 0, 16.6, 16.3, 105, 103.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 3, 0, 17.1, 16.8, 106.7, 105, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 6, 0, 17.6, 17.3, 108.4, 106.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 9, 0, 18.1, 17.8, 110, 108.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 5, 0, 0, 18.6, 18.3, 111.7, 110, 0, 0));

        listSD.add(new DataSD("laki-laki", 0, 0, 0, 3.2, 2.9, 49.7, 48, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 1, 0, 4.2, 3.9, 54.5, 52.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 2, 0, 5.2, 4.9, 58.1, 56.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 3, 0, 6, 5.7, 61.1, 59.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 4, 0, 6.5, 6.2, 63.5, 61.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 5, 0, 6.9, 6.7, 65.5, 63.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 6, 0, 7.4, 7.1, 67.2, 65.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 7, 0, 7.7, 7.4, 68.7, 67, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 8, 0, 8.2, 7.7, 70.1, 68.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 9, 0, 8.3, 8, 71.4, 69.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 10, 0, 8.5, 8.2, 72.7, 71, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 11, 0, 8.7, 8.4, 73.9, 72.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 0, 0, 8.9, 8.6, 75.1, 73.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 3, 0, 9.5, 9.2, 78.3, 76.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 6, 0, 10.1, 9.8, 81.3, 79.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 9, 0, 10.6, 10.3, 84, 82.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 0, 0, 11.1, 10.8, 86.5, 84.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 3, 0, 11.7, 11.3, 88.1, 86.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 6, 0, 12.1, 11.8, 90.2, 88.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 9, 0, 12.6, 12.3, 92.2, 90.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 0, 0, 13, 12.7, 94.1, 92.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 3, 0, 13.4, 13.1, 95.9, 94.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 6, 0, 13.9, 13.6, 97.6, 95.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 9, 0, 14.3, 14, 99.2, 97.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 0, 0, 14.7, 14.4, 100.8, 99.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 3, 0, 15.1, 14.8, 102.4, 100.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 6, 0, 16.5, 15.2, 104, 102.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 9, 0, 15.9, 15.6, 105.5, 103.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 5, 0, 0, 16.3, 16, 107, 105.3, 0, 0));

        listSD.add(new DataSD("laki-laki", 0, 0, 0, 2.8, 2.5, 47.8, 46.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 1, 0, 3.7, 3.4, 52.5, 50.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 2, 0, 4.7, 4.3, 56.1, 54.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 3, 0, 5.3, 5, 59, 57.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 4, 0, 5.9, 5.6, 61.4, 59.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 5, 0, 6.3, 6, 67.4, 61.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 6, 0, 6.7, 6.4, 65, 63.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 7, 0, 7, 6.7, 66.5, 64.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 8, 0, 7.2, 6.9, 67.9, 66.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 9, 0, 7.4, 7.1, 69.2, 67.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 10, 0, 7.7, 7.4, 70.4, 68.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 11, 0, 7.9, 7.6, 71.6, 69.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 0, 0, 8, 7.7, 72.7, 71, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 3, 0, 8.6, 8.3, 75.8, 74.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 6, 0, 9.1, 8.8, 78.6, 76.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 9, 0, 9.5, 9.2, 81.1, 79.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 0, 0, 10, 9.7, 83.4, 81.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 3, 0, 10.4, 10.1, 84.8, 83.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 6, 0, 10.8, 10.5, 86.8, 85.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 9, 0, 11.2, 10.9, 88.6, 86.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 0, 0, 11.6, 11.3, 90.4, 88.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 3, 0, 11.9, 11.6, 92, 90.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 6, 0, 12.3, 12, 93.6, 91.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 9, 0, 12.7, 12.4, 95.2, 93.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 0, 0, 13, 12.7, 96.6, 94.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 3, 0, 13.4, 13.1, 98.1, 96.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 6, 0, 13.7, 13.4, 99.5, 97.8, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 9, 0, 14, 13.7, 101, 99.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 5, 0, 0, 14.4, 14.1, 102.4, 100.7, 0, 0));

        listSD.add(new DataSD("laki-laki", 0, 0, 0, 2.4, 2.1, 45.9, 44.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 1, 0, 3.2, 2.9, 50.1, 48.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 2, 0, 4.1, 3.8, 54.1, 52.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 3, 0, 4.7, 4.4, 57, 55.3, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 4, 0, 5.2, 4.9, 59.3, 57.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 5, 0, 5.6, 5.3, 61.3, 59.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 6, 0, 6, 5.7, 62.9, 61.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 7, 0, 6.2, 5.9, 64.4, 62.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 8, 0, 6.5, 6.2, 66.1, 64, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 9, 0, 6.7, 6.4, 66.9, 65.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 10, 0, 6.9, 6.6, 68.1, 66.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 0, 11, 0, 7.1, 6.8, 69.3, 67.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 0, 0, 7.2, 6.9, 70.3, 68.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 3, 0, 7.7, 7.4, 73.3, 71.6, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 6, 0, 8.1, 7.8, 75.9, 74.2, 0, 0));
        listSD.add(new DataSD("laki-laki", 1, 9, 0, 8.5, 8.2, 78.2, 76.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 0, 0, 8.9, 8.6, 80.4, 78.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 3, 0, 9.3, 9, 81.6, 79.9, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 6, 0, 9.7, 9.4, 83.4, 81.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 2, 9, 0, 10, 9.7, 85.1, 83.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 0, 0, 10.3, 10, 86.7, 85, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 3, 0, 10.7, 10.3, 88.2, 86.5, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 6, 0, 10.9, 10.6, 89.7, 88, 0, 0));
        listSD.add(new DataSD("laki-laki", 3, 9, 0, 11.2, 10.9, 91.1, 89.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 0, 0, 11.5, 11.2, 92.4, 90.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 3, 0, 11.8, 11.5, 93.7, 92.1, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 6, 0, 12.2, 11.8, 95, 93.4, 0, 0));
        listSD.add(new DataSD("laki-laki", 4, 9, 0, 12.4, 12.1, 96.4, 94.7, 0, 0));
        listSD.add(new DataSD("laki-laki", 5, 0, 0, 12.7, 12.4, 97.8, 96.1, 0, 0));
    }

    public int search(String jenis_kelamin, int tahun, int bulan, double BB, double TB){
        for (int i = 0; i < listSD.size(); i++){//looping semua data di listSD
            DataSD dataSD = listSD.get(i);
            if (dataSD.getJenis_kelamin().equalsIgnoreCase(jenis_kelamin)){
                if (dataSD.getTahun()==tahun&&dataSD.getBulan()==bulan){
                    if ((BB>=dataSD.getBeratBawah()&&BB<=dataSD.getBeratAtas())&&(TB>=dataSD.getTinggiBawah()&&TB>=dataSD.getTinggiAtas())){
                        return dataSD.getSD();
                    }
                }
            }

        }
        return 1;
    }

    public int searchBBUmur(String jenis_kelamin, int tahun, int bulan, double BB){
        for (int i = 0; i < listSDBBUmur.size(); i++){
            DataSD dataSD = listSDBBUmur.get(i);
            if (dataSD.getJenis_kelamin().equalsIgnoreCase(jenis_kelamin)){
                if (dataSD.getTahun()==tahun&&dataSD.getBulan()==bulan){
                    if (BB>=dataSD.getBeratBawah()&&BB<=dataSD.getBeratAtas()){
                        return dataSD.getSD();
                    }
                }
            }

        }
        return 1;
    }


}
