# Help

To use this class just call:
```java
CustomListAdapter customAdapter = new CustomListAdapter(context, R.layout.item_list_row, dados, null);
yourListView.setAdapter(customAdapter);
customAdapter.notifyDataSetChanged();
```

You can also:
  - ```context``` can be getActivity() or the view at onCreateView()'s fragment;
  - ```dados``` is an ArrayList.
  - ```item_list_row``` is a layout. You must change it to be compatible with your problem;
  - ```yourListView``` is a class attribute, but you cand make it a local variable;
