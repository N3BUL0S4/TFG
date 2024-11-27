import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Article } from '../../Models/Article';
import { ArticleService } from '../../Service/article.service';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrl: './create-article.component.css'
})
export class CreateArticleComponent {
  articleForm!: FormGroup;
  article:Article = new Article(1,"","","","","","",0)

  constructor(private fb: FormBuilder, public as:ArticleService) {}

  ngOnInit(): void {
    this.articleForm = this.fb.group({
      model: ['', [Validators.required]],
      description: ['', [Validators.required, Validators.maxLength(255)]],
      color: ['#000000', [Validators.required]],
      size: ['', [Validators.required]],
      stock: ['0', [Validators.required, Validators.min(0)]]
    });
  }

  onSubmit(): void {
    if (this.articleForm.valid) {
      let article = this.article
      article.id = (this.as.articles[this.as.articles.length-1].id).valueOf()+1
      article.model = this.articleForm.value.model
      article.description = this.articleForm.value.description
      article.color = this.articleForm.value.color
      article.size = this.articleForm.value.size
      article.stock = this.articleForm.value.stock
      if (!this.as.findById(article.id)) {
        alert("Artículo creardo correctamente")
        this.as.create(article)
      } else {
        alert("Error al crear el artículo")
      }
      console.log()
      this.articleForm.reset()
    }
  }
  
  imagenes() {

  }
}
