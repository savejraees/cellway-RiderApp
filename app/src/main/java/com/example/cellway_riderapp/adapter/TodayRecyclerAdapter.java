package com.example.cellway_riderapp.adapter;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.sip.SipManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cellway_riderapp.R;
import com.example.cellway_riderapp.fragments.CheckInformationFragment;
import com.example.cellway_riderapp.model.TodayItemModel;

import java.util.ArrayList;

public class TodayRecyclerAdapter extends RecyclerView.Adapter<TodayRecyclerAdapter.TodayHolder> {

    ArrayList<TodayItemModel> listItem;
    Context context;

    public TodayRecyclerAdapter(Context context, ArrayList<TodayItemModel> listItem) {
        this.listItem = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public TodayHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = (LayoutInflater.from(context)).inflate(R.layout.row_customer_info, parent, false);
        return new TodayHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TodayHolder holder, int position) {
        final TodayItemModel model = listItem.get(position);
        holder.txtName.setText(model.getName());
        holder.txtMobile.setText(model.getMobile());
        holder.txtAltMobile.setText(model.getAltMobile());
        holder.txtAddress.setText(model.getAddress());
        holder.txtDate.setText(model.getTime_date());
        holder.txtBrand.setText(model.getBrand());
        holder.txtModel.setText(model.getModel());
        holder.txtgb.setText(model.getGb());


        holder.imgMob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+model.getMobile()));
                context.startActivity(it);

                 }
             });

        holder.imgMobAlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_DIAL);
                it.setData(Uri.parse("tel:"+model.getMobile()));
                context.startActivity(it);

                 }
             });
             holder.btnConfirm.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     context.startActivity(new Intent(context,CheckInformationFragment.class)
                     .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
//                     AppCompatActivity activity = (AppCompatActivity)view.getContext();
//                     CheckInformationFragment fragment = new CheckInformationFragment();
//                   activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame,fragment).addToBackStack(null).commit();
                 }
             });

             holder.btnReject.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                    final Dialog dialog =new Dialog(context);
                    dialog.setContentView(R.layout.dialog_reject);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setCancelable(false);
                    final EditText edt_reason = dialog.findViewById(R.id.edt_reason);
                    Button btn_OkDialog = dialog.findViewById(R.id.btn_OkDialog);
                    dialog.show();

                     btn_OkDialog.setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             if(edt_reason.getText().toString().isEmpty()){
                                 edt_reason.setError("Can't be Blank");
                                 edt_reason.requestFocus();
                             }else {
                                 dialog.dismiss();
                             }
                         }
                     });
                 }
             });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }


    public class TodayHolder extends RecyclerView.ViewHolder{
       TextView txtName,txtMobile,txtAltMobile,txtAddress,txtDate,txtBrand,txtModel,txtgb;
       Button btnConfirm,btnReject;
       ImageView imgMob,imgMobAlt;
        public TodayHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtMobile = itemView.findViewById(R.id.txtMobile);
            txtAltMobile = itemView.findViewById(R.id.txtAltMobile);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtBrand = itemView.findViewById(R.id.txtBrand);
            txtModel = itemView.findViewById(R.id.txtModel);
            txtgb = itemView.findViewById(R.id.txtgb);
            btnConfirm = itemView.findViewById(R.id.btnConfirm);
            btnReject = itemView.findViewById(R.id.btnReject);
            imgMob = itemView.findViewById(R.id.imgMob);
            imgMobAlt = itemView.findViewById(R.id.imgMobAlt);
        }
    }
}
