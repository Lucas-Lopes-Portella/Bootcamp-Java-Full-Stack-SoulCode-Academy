import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../auth/services/auth.service';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  constructor(private authService: AuthService) {}

  /*
   request representa a requisição que foi interceptada (GET|POST|PUT|DELETE)
   next dará continuidade a requisição
  */
  intercept(
    request: HttpRequest<unknown>,
    next: HttpHandler
  ): Observable<HttpEvent<unknown>> {
    /* 
    recuperar a requisição e ver se há um token para ser enviado

    Se o token existir, ele adicionará o token a requisição e ela continuará.
    Se não existir, ele não adicionará e a requisição continuará sem o token
    */

    const token = this.authService.recuperarToken();

    if (token) {
      const clone = request.clone({
        headers: request.headers.set('Authorization', `Bearer ${token}`),
      });
      return next.handle(clone);
    }

    return next.handle(request);
  }
}
