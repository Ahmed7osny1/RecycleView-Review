Smart way to update RecyclerView using DiffUtil

Now say good bye to notifyDataSetChanged()…
We generally use List in any of our day to day development. It also requires to update the list data when user scrolls the list.
To achieve this, we often fetch the data from server and update the newly received items.

If there is a small delay during this process it impact on the user experience so we want this to be done as soon as possible with along with less resources.

When the content of our list gets changed, we have to call notifyDataSetChanged() to get the updates but it is very costly.
There are so many iterations for getting the job done in the case of notifyDataSetChanged().

Here DiffUtil class comes into picture and Android developed this utility class to handle data updates for a RecyclerView.

What is DiffUtil
As of 24.2.0, RecyclerView support library, v7 package offers really handy utility class called DiffUtil.
This class finds the difference between two lists and provides the updated list as an output. This class is used to notify updates to a RecyclerView Adapter.

It uses Eugene W. Myers’s difference algorithm to calculate the minimal number of updates.

How to use?
DiffUtil.Callback is an abstract class and used as callback class by DiffUtil while calculating the difference between two lists. 
It has four abstract methods and one non-abstract method. You have to extend it and override all its methods-

getOldListSize()– Return the size of the old list.

getNewListSize()– Return the size of the new list.

areItemsTheSame(int oldItemPosition, int newItemPosition)– It decides whether two objects are representing same items or not.

areContentsTheSame(int oldItemPosition, int newItemPosition)– It decides whether two items have same data or not.
This method is called by DiffUtil only if areItemsTheSame() returns true.

getChangePayload(int oldItemPosition, int newItemPosition)– If areItemTheSame() returns true and areContentsTheSame() 
returns false than DiffUtil utility calls this method to get a payload about the change.


Call dispatchUpdatesTo(RecyclerView.Adapter) to dispatch the updated list. DiffResult object that is returned from diff calculation,
dispatches the changes to the Adapter, and adapter will be notified about the change.

Object returned in getChangePayload() is dispatched from DiffResult using notifyItemRangeChanged(position, count, payload),
upon which is called Adapter’s onBindViewHolder(… List<Object> payloads) method.


DiffUtil also uses methods of RecyclerView.Adapter to notify the Adapter to update the data set:

notifyItemMoved()
notifyItemRangeChanged()
notifyItemRangeInserted()
notifyItemRangeRemoved()
You can read more details on RecyclerView.Adapter and its method here.

Important:
If the lists are large, this operation may take significant time so you are advised to run this on a background thread,
get the DiffUtil#DiffResult then apply it on the RecyclerView on the main thread. Also max size of the list can be 2²⁶ due to implementation constraints.

Performance
DiffUtil requires O(N) space to find the minimal number of addition and removal operations between the two lists.
It’s expected performance is O(N + D²) where N is the total number of added and removed items and D is the length of the edit script. 
You can walk through the official page of Android for more performance figures.
