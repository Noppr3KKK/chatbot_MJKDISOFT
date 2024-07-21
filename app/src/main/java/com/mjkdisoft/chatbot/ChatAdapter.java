package com.mjkdisoft.chatbot;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mjkdisoft.chatbot.databinding.BotLayoutBinding;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ChatModel> chatList;
    private boolean isRomance;
    private boolean isComedy;
    private boolean isTechnology;
    private static final int VIEW_TYPE_BOT = 0;
    private static final int VIEW_TYPE_HUMAN = 1;
    private static final int VIEW_TYPE_BOT_ROMANCE = 2;
    private static final int VIEW_TYPE_HUMAN_ROMANCE = 3;
    private static final int VIEW_TYPE_BOT_COMEDY = 4;
    private static final int VIEW_TYPE_HUMAN_COMEDY = 5;
    private static final int VIEW_TYPE_BOT_TECHNOLOGY = 6;
    private static final int VIEW_TYPE_HUMAN_TECHNOLOGY = 7;

    public ChatAdapter(List<ChatModel> chatList, boolean isRomance, boolean isComedy, boolean isTechnology) {
        this.chatList = chatList;
        this.isRomance = isRomance;
        this.isComedy = isComedy;
        this.isTechnology = isTechnology;
    }

    @Override
    public int getItemViewType(int position) {
        ChatModel chatModel = chatList.get(position);
        if (isRomance) {
            return chatModel.isBot() ? VIEW_TYPE_BOT_ROMANCE : VIEW_TYPE_HUMAN_ROMANCE;
        } else if (isComedy) {
            return chatModel.isBot() ? VIEW_TYPE_BOT_COMEDY : VIEW_TYPE_HUMAN_COMEDY;
        } else if (isTechnology) {
            return chatModel.isBot() ? VIEW_TYPE_BOT_TECHNOLOGY : VIEW_TYPE_HUMAN_TECHNOLOGY;
        } else {
            return chatModel.isBot() ? VIEW_TYPE_BOT : VIEW_TYPE_HUMAN;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_BOT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_layout, parent, false);
            return new BotViewHolder(view);
        } else if (viewType == VIEW_TYPE_HUMAN) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.human_layout, parent, false);
            return new HumanViewHolder(view);
        } else if (viewType == VIEW_TYPE_BOT_ROMANCE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_layout2, parent, false);
            return new BotRomanceViewHolder(view);
        } else if (viewType == VIEW_TYPE_HUMAN_ROMANCE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.human_layout2, parent, false);
            return new HumanRomanceViewHolder(view);
        } else if (viewType == VIEW_TYPE_BOT_COMEDY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_layout3, parent, false);
            return new BotComedyViewHolder(view);
        } else if (viewType == VIEW_TYPE_HUMAN_COMEDY) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.human_layout3, parent, false);
            return new HumanComedyViewHolder(view);
        } else if (viewType == VIEW_TYPE_BOT_TECHNOLOGY){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bot_layout4, parent, false);
            return new BotTechnologyViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.human_layout4, parent, false);
            return new HumanTechnologyViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatModel chatModel = chatList.get(position);
        if (holder instanceof BotViewHolder) {
            ((BotViewHolder) holder).bind(chatModel);
        } else if (holder instanceof HumanViewHolder) {
            ((HumanViewHolder) holder).bind(chatModel);
        } else if (holder instanceof BotRomanceViewHolder) {
            ((BotRomanceViewHolder) holder).bind(chatModel);
        } else if (holder instanceof HumanRomanceViewHolder){
            ((HumanRomanceViewHolder) holder).bind(chatModel);
        } else if (holder instanceof BotComedyViewHolder) {
            ((BotComedyViewHolder) holder).bind(chatModel);
        } else if (holder instanceof HumanComedyViewHolder){
            ((HumanComedyViewHolder) holder).bind(chatModel);
        } else if (holder instanceof BotTechnologyViewHolder) {
            ((BotTechnologyViewHolder) holder).bind(chatModel);
        } else {
            ((HumanTechnologyViewHolder) holder).bind(chatModel);
        }
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    static class BotViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        BotViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }

    static class HumanViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        HumanViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }

    static class BotRomanceViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        BotRomanceViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }

    static class HumanRomanceViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        HumanRomanceViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }
    static class BotComedyViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        BotComedyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }
    static class HumanComedyViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        HumanComedyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }
    static class BotTechnologyViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        BotTechnologyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }
    static class HumanTechnologyViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView timeTextView;

        HumanTechnologyViewHolder(@NonNull View itemView) {
            super(itemView);
            messageTextView = itemView.findViewById(R.id.textMessage);
            timeTextView = itemView.findViewById(R.id.textTime);
        }

        void bind(ChatModel chatModel) {
            messageTextView.setText(chatModel.getMessage());
            timeTextView.setText(chatModel.getTimeSent());
        }
    }
}
