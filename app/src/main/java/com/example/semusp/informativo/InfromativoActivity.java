package com.example.semusp.informativo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.semusp.R;

import java.util.ArrayList;
import java.util.List;


public class InfromativoActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infromativo);
        getSupportActionBar().hide();
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        PostAdapter postAdapter = new PostAdapter();
        rv.setAdapter(postAdapter);
        DividerItemDecoration dividerItemDecoration  = new DividerItemDecoration(rv.getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        rv.addItemDecoration(dividerItemDecoration);
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post();
        post1.setImageViewUser(R.drawable.perfil);
        post1.setImageViewPost(R.drawable.post);
        post1.setTextViewUsername("SEMMA - Oriximiná");
        post1.setTextViewContent("Hoje 22 de março é comemorado o dia Internacional da água. A data foi criada com objetivo de alertar a população mundial sobre a importância da preservação da água para a sobrevivência de todos os ecossistemas do planeta. ");
        post1.setTextViewTitle("https://www.facebook.com/semmaorixi".toUpperCase());
        post1.setTextViewSubtitle("A secretaria de meio ambiente está promovendo diversas atividades para protegê-los, como fiscalização, a limpeza correta das margens e principalmente a desativação do lixão, que irá preservar nossos aquíferos, que são nossas águas subterrâneas.");
        post1.setTextViewTime("2 min");
        posts.add(post1);

        Post post2 = new Post();
        post2.setImageViewUser(R.drawable.defcivil);
        post2.setImageViewPost(R.drawable.defesa_civil);
        post2.setTextViewUsername("Defesa Civil - Oriximiná");
        post2.setTextViewContent("Está chegando o período Chuvoso e durante os seis meses de chuvas não jogue lixos e entulhos nas ruas!\n" +
                "Pois, poderá entupir bueiros e canaletas. As enxurradas também levam todos esses lixos e entulhos até os seus quintais, podendo causar alagamentos em suas residências.\n" +
                "DEVEMOS FAZER A PREVENÇÃO PARA EVITAR ACIDENTES!\n" +
                "José Paulo Pereira Paixão - Coordenador da Defesa Civil Municipal e sua equipe de serviço.");
        post2.setTextViewTime("15 min");

        posts.add(post2);
        posts.add(post1);
        posts.add(post2);
        posts.add(post1);
        posts.add(post2);
        postAdapter.setPosts(posts);
        postAdapter.notifyDataSetChanged();

    }
    private static class PostViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageViewUser;
        private final TextView textViewTime;
        private final TextView textViewUsername;
        private final TextView textViewContent;
        private final ImageView imageViewPost;
        private final TextView textViewTitle;
        private final TextView textViewSubtitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.image_view_user);
            imageViewPost = itemView.findViewById(R.id.image_view_post);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewUsername = itemView.findViewById(R.id.text_username);
            textViewContent = itemView.findViewById(R.id.text_view_content);
            textViewTitle = itemView.findViewById(R.id.tex_view_post_title);
            textViewSubtitle = itemView.findViewById(R.id.tex_view_post_subtitle);


        }
        void bind (Post post) {
            imageViewPost.setImageResource(post.getImageViewPost());
            imageViewUser.setImageResource(post.getImageViewUser());
            textViewTime.setText(post.getTextViewTime());
            textViewUsername.setText(post.getTextViewUsername());
            textViewContent.setText(post.getTextViewContent());
            textViewTitle.setText(post.getTextViewTitle());
            textViewSubtitle.setText(post.getTextViewSubtitle());

            if (post.getTextViewTitle() == null) {
                itemView.findViewById(R.id.post_container).setVisibility(View.GONE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post, "1:1");
                constraintSet.applyTo((ConstraintLayout) itemView);

            } else {
                itemView.findViewById(R.id.post_container).setVisibility(View.VISIBLE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post, "16:9");
                constraintSet.applyTo((ConstraintLayout) itemView);

            }




        }
    }
    private class PostAdapter extends RecyclerView.Adapter<PostViewHolder> {
        private List<Post> posts = new ArrayList<>();

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = getLayoutInflater().inflate(R.layout.feed_item, viewGroup, false);
            return new PostViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PostViewHolder postViewHolder, int i) {
            Post post = posts.get(i);
            postViewHolder.bind(post);

        }
        public void setPosts(List<Post> posts)  {
            this.posts = posts;
        }

        public List<Post> getPosts() {
            return posts;
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }
    }

    private class Post {
        private int ImageViewUser;
        private String textViewTime;
        private String textViewUsername;
        private String textViewContent;
        private int imageViewPost;
        private String textViewTitle;
        private String textViewSubtitle;

        public int getImageViewUser() {
            return ImageViewUser;
        }

        public void setImageViewUser(int imageViewUser) {
            ImageViewUser = imageViewUser;
        }

        public String getTextViewTime() {
            return textViewTime;
        }

        public void setTextViewTime(String textViewTime) {
            this.textViewTime = textViewTime;
        }

        public String getTextViewUsername() {
            return textViewUsername;
        }

        public void setTextViewUsername(String textViewUsername) {
            this.textViewUsername = textViewUsername;
        }

        public String getTextViewContent() {
            return textViewContent;
        }

        public void setTextViewContent(String textViewContent) {
            this.textViewContent = textViewContent;
        }

        public int getImageViewPost() {
            return imageViewPost;
        }

        public void setImageViewPost(int imageViewPost) {
            this.imageViewPost = imageViewPost;
        }

        public String getTextViewTitle() {
            return textViewTitle;
        }

        public void setTextViewTitle(String textViewTitle) {
            this.textViewTitle = textViewTitle;
        }

        public String getTextViewSubtitle() {
            return textViewSubtitle;
        }

        public void setTextViewSubtitle(String textViewSubtitle) {
            this.textViewSubtitle = textViewSubtitle;
        }
    }

}