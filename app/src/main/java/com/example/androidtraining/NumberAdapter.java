package com.example.androidtraining;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.NumberViewHolder> {

    private static int viewHolderCount;
    private int numberItems;
    private Context parent;

    public NumberAdapter(int numberItems, Context parent) {
        this.numberItems = numberItems;
        viewHolderCount = 0;
        this.parent = parent;
    }

    /** Начальное создание некоторого количества ViewHolder
     * @param parent - RecycleView
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.number_list_item;//id XML файла??
        //LayoutInflater - класс, кот. позволяет из XML файла создавать новые представления (java-объекты)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForListItem, parent, false);
        NumberViewHolder viewHolder = new NumberViewHolder(view);
        viewHolder.viewHolderIndex.setText("ViewHolder index: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    /** У созданных ViewHolder меняем их значения
     * @param viewHolder
     * @param position
     */
    // обычно в данном методе берутся данные из источника данных и помещаются в список
    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder viewHolder, int position) {
        viewHolder.bind(position);
    }

    /** Возвращает общее количество элементов в списке
     * @return
     */
    @Override
    public int getItemCount() {
        return this.numberItems;
    }

    /**
     * Обертка для элемента списка
     */
    class NumberViewHolder extends RecyclerView.ViewHolder {

        TextView listItemNumberView;
        TextView viewHolderIndex;

        /**
         * @param itemView элемент списка (генерируется с помощью number_list_item.xml)
         */
        public NumberViewHolder(@NonNull View itemView) {
            super(itemView);
            this.listItemNumberView = itemView.findViewById(R.id.tv_number_item);
            this.viewHolderIndex =  itemView.findViewById(R.id.tv_view_holder_number);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int positionIndex = getAdapterPosition();
                    Toast toast = Toast.makeText(
                            parent,
                            "Element " + positionIndex + " was clicked!",
                            Toast.LENGTH_SHORT);
                    toast.show();
                }
            });
        }

        void bind(int listIndex){
            this.listItemNumberView.setText(String.valueOf(listIndex));
        }
    }
}
