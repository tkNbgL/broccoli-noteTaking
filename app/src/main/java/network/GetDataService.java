package network;

import java.util.ArrayList;

import model.RetroTextList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("takeNote/")
    Call<ArrayList<RetroTextList>> getOneTexts();
}
