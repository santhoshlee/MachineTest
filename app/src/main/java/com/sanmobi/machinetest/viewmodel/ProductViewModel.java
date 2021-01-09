package com.sanmobi.machinetest.viewmodel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.sanmobi.machinetest.model.Category;
import com.sanmobi.machinetest.network.APIService;
import com.sanmobi.machinetest.network.RetroInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<Category> category;

    public ProductViewModel() {
        category=new MutableLiveData<>();
    }

    public MutableLiveData<Category> getProductListObserver(){
        return category;
    }
    public void makeApiCall(){

        APIService apiService= RetroInstance.getRetrofitClient().create(APIService.class);

        Call<Category> call=apiService.getProductList();

        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                category.postValue(response.body());
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                t.getMessage();
            }
        });
    }
}
