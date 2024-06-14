import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrl: './create-article.component.css'
})
export class CreateArticleComponent {
  articleForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.articleForm = this.fb.group({
      modelo: ['', [Validators.required]],
      descripcion: ['', [Validators.required, Validators.maxLength(255)]],
      color: ['#000000', [Validators.required]],
      talla: ['', [Validators.required]],
      existencia: ['0', [Validators.required, Validators.min(0)]]
    });
  }

  onSubmit(): void {
    if (this.articleForm.valid) {
      console.log('Formulario válido:', this.articleForm.value);
      this.articleForm.reset({
      });
      alert("No se a podido crear el artticulo")
    }
  }
}
