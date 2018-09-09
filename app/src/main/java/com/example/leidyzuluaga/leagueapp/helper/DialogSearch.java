package com.example.leidyzuluaga.leagueapp.helper;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;


import com.example.leidyzuluaga.leagueapp.R;
import com.example.leidyzuluaga.leagueapp.models.League;

import java.util.ArrayList;
import java.util.List;

public class DialogSearch extends Dialog{

    private final ArrayList<League> itemsOriginal;
    private final ArrayList<League> itemsCopy;
    private final IDialogSelection alertSelection;
    private EditText editTextTemplateFilter;
    private ListView listViewTemplate;
    private TextView textViewTemplateEmptySearch;
    private ImageButton imageButtonTemplateClearFilter;

    private void loadViews() {
        editTextTemplateFilter = findViewById(R.id.editTextTemplateFilter);
        listViewTemplate = findViewById(R.id.listViewTemplate);
        textViewTemplateEmptySearch = findViewById(R.id.textViewTemplateEmptySearch);
        imageButtonTemplateClearFilter = findViewById(R.id.imageButtonTemplateClearFilter);
    }

    public DialogSearch(Context context, ArrayList<League> items, IDialogSelection alertSelection) {
        super(context);
        itemsOriginal = items;
        itemsCopy = (ArrayList<League>) items.clone();
        this.alertSelection = alertSelection;
    }

    private final TextWatcher textWatcherSearch = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            textViewTemplateEmptySearch.setVisibility(View.GONE);
            imageButtonTemplateClearFilter.setVisibility(View.GONE);
            itemsCopy.clear();
            for (League item : itemsOriginal) {
                if (item.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                    itemsCopy.add(item);
                }
            }
            if (itemsCopy.size() == 0) {
                textViewTemplateEmptySearch.setVisibility(View.VISIBLE);
            }
            if (!editTextTemplateFilter.getText().toString().isEmpty()) {
                imageButtonTemplateClearFilter.setVisibility(View.VISIBLE);
            }
            String[] items = getItemsArrayFromItemLeagueList(itemsCopy);
            listViewTemplate.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items));
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    private final ListView.OnItemClickListener listView = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if (alertSelection != null) {
                alertSelection.onResult(itemsCopy, position);
            }
            dismiss();
        }
    };

    private String[] getItemsArrayFromItemLeagueList(List<League> LeagueList) {
        String[] items = new String[LeagueList.size()];
        for (int position = 0; position < LeagueList.size(); position++) {
            items[position] = LeagueList.get(position).getName();
        }
        return items;
    }

    private void bindEvents() {
        editTextTemplateFilter.addTextChangedListener(textWatcherSearch);
        listViewTemplate.setOnItemClickListener(listView);
        imageButtonTemplateClearFilter.setOnClickListener(btnOnclickClearFilter);
    }

    private final View.OnClickListener btnOnclickClearFilter = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            editTextTemplateFilter.setText(Constants.EMPTY_STRING);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template_filter);
        loadViews();
        bindEvents();
        editTextTemplateFilter.setText(Constants.EMPTY_STRING);
    }

    public interface IDialogSelection {
        void onResult(ArrayList<League> itemsCopy, int position);
    }
}
