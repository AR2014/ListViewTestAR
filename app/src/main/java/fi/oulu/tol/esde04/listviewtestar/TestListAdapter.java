package fi.oulu.tol.esde04.listviewtestar;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

/** Created by anita on 2.4.2015. */
public class TestListAdapter implements ListAdapter {
    @Override
    public boolean areAllItemsEnabled() { return false;  }

    @Override
    public boolean isEnabled(int position) { return true;  }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {    }

    @Override
    public int getCount() { return 4;  }

    @Override
    public Object getItem(int position) { return null;  }

    @Override
    public long getItemId(int position) { return 0;  }

    @Override
    public boolean hasStableIds() { return true;   }

    private static class ViewHolder{
        public TextView rowTextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       ViewHolder viewHolder;
        if (convertView==null){
            Context context=parent.getContext();
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.row_test,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.rowTextView=(TextView)convertView.findViewById(R.id.rowTextView);
            convertView.setTag(viewHolder);
                    }
        else
        viewHolder=(ViewHolder)convertView.getTag();
       // viewHolder.rowTextView.setText("Valot"+position);
        viewHolder.rowTextView.setText(prefix +position);

        return convertView;
    }

    @Override
    public int getItemViewType(int position) { return 0;    }

    @Override
    public int getViewTypeCount() { return 1;    }

    @Override
    public boolean isEmpty() { return false;   }

    private String prefix;
    public  TestListAdapter(String prefix){
        this.prefix=prefix;
    }
}
