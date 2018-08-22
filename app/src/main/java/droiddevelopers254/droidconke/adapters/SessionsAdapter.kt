package droiddevelopers254.droidconke.adapters

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import droiddevelopers254.droidconke.R
import droiddevelopers254.droidconke.models.SessionsModel
import kotlinx.android.synthetic.main.session_details.view.*

class SessionsAdapter(private val context: Context, private val sessionsModelList: List<SessionsModel>, private val dayNumber: String) : RecyclerView.Adapter<SessionsAdapter.MyViewHolder>() {

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sessionTitleText = itemView.sessionTitleText
        private val sessionDetailsLinear = itemView.sessionDetailsLinear
        private val sessionRoomText = itemView.sessionRoomText
        private val sessionLabelText = itemView.sessionLabelText
        private val sessionCategoryText = itemView.sessionCategoryText

       fun bindSession(sessionsModel: SessionsModel){
           with(sessionsModel){
               sessionTitleText.text = title
               sessionLabelText.setBackgroundColor(Color.parseColor(session_color))
               sessionCategoryText.text = topic
               sessionRoomText.text= "$duration / $room / $time_in_am $am_pm_label"
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.session_details, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.bindSession(sessionsModelList[position])
    }

    override fun getItemCount(): Int {
        return sessionsModelList.size
    }


}